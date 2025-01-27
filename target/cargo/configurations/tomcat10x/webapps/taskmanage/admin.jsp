<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background: #333;
            color: white;
            padding: 1em;
            text-align: center;
        }

        .container {
            display: flex;
            height: 100vh;
        }

        .sidebar {
            width: 20%;
            background: #333;
            color: white;
            padding: 10px;
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .sidebar a {
            text-decoration: none;
            color: white;
            padding: 10px;
            background: #444;
            border-radius: 5px;
            text-align: center;
            cursor: pointer;
        }

        .sidebar a:hover {
            background: #555;
        }

        .content {
            flex: 1;
            padding: 20px;
            background: white;
            overflow-y: auto;
        }

        .hidden {
            display: none;
        }

        .active {
            display: block;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table,
        th,
        td {
            border: 1px solid #ddd;
        }

        th,
        td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: white;
        }

        .btn {
            padding: 8px 16px;
            margin: 5px 0;
            background-color: #333;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .btn:hover {
            background-color: #555;
        }
    </style>
</head>

<body>
    <header>
        <h1>Admin Dashboard</h1>
    </header>
    <div class="container">
        <div class="sidebar">
            <a onclick="showSection('assign-task')">Assign Tasks</a>
            <a onclick="taskServlet()">Task Responses (Pending)</a>
            <a onclick="completedtasks('task-status')">Task Status</a>
        </div>

        <div class="content">
            <div id="assign-task" class="hidden">
                <h2>Assign Task</h2>
                <form onsubmit="taskassign(event)">
                    <table>
                        <tr>
                            <td>
                                <label for="user_id">User ID:</label>
                                <input type="text" id="user_id" name="user_id" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="task_name">Task Title:</label>
                                <input type="text" id="task_name" name="task_name" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="task_description">Task Description:</label>
                                <input type="text" id="task_description" name="task_description" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="due_date">Task Deadline:</label>
                                <input type="date" id="due_date" name="due_date" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <center><button type="submit" class="btn">Create Task</button></center>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>

            <div id="pending-tasks" class="hidden">
                <!-- Pending tasks will be populated here dynamically -->
            </div>

           

            <div id="task-status" class="hidden">
               
            </div>
    </div>

    <script>
        function taskassign(event) {
            event.preventDefault();

            const userId = document.getElementById('user_id').value;
            const taskName = document.getElementById('task_name').value;
            const taskDescription = document.getElementById('task_description').value;
            const dueDate = document.getElementById('due_date').value;

            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        alert('Task assigned successfully!');
                        document.getElementById('user_id').value = '';
                        document.getElementById('task_name').value = '';
                        document.getElementById('task_description').value = '';
                        document.getElementById('due_date').value = '';
                    } else {
                        alert('Error: Unable to assign task.');
                    }
                }
            };

            xhr.open('POST', 'createTask.do', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(`user_id=${encodeURIComponent(userId)}&task_name=${encodeURIComponent(taskName)}&task_description=${encodeURIComponent(taskDescription)}&due_date=${encodeURIComponent(dueDate)}`);
        }

        function showSection(sectionId) {
            const sections = document.querySelectorAll('.content > div');
            sections.forEach((section) => {
                section.classList.add('hidden');
            });

            const section = document.getElementById(sectionId);
            if (section) {
                section.classList.remove('hidden');
                if (sectionId === 'pending-tasks') {
                }
            }
        }

        function taskServlet() {
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    const taskSection = document.getElementById("pending-tasks");
                    if (xhr.status === 200) {
                        taskSection.innerHTML = xhr.responseText;
                        showSection("pending-tasks");
                    } else {
                        taskSection.innerHTML = `<p style="color: red;">Error fetching tasks. Please try again later.</p>`;
                        showSection("pending-tasks");
                    }
                }
            };

            xhr.open("GET", `TaskServlet.do`, true);
            xhr.send();
        }

        // Show reassign modal
        function showReassignModal(taskId) {
            document.getElementById('reassign_task_id').value = taskId;
            document.getElementById('reassignModal').classList.remove('hidden');
        }

        // Close reassign modal
        function closeReassignModal() {
            document.getElementById('reassignModal').classList.add('hidden');
        }

        // Update task with new user ID
        function reassignTask(taskId) {
    // Get the new user ID from the input field
    const newUserId = document.getElementById('reassign_user_id' + taskId).value;

    if (!newUserId) {
        alert('Please enter a valid User ID.');
        return;
    }

    // Create a new XMLHttpRequest object
    const xhr = new XMLHttpRequest();

    // Set up the request with the appropriate action
    xhr.open('POST', 'TaskReassign.do', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    // Handle the response
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert('Task reassigned successfully!');
                // Optionally refresh the task list or perform other actions
                fetchPendingTasks();
            } else {
                alert(`Error: ${xhr.responseText}`);
            }
        }
    };

    // Send the request with taskId and newUserId as parameters
    const params = `action=reassignTask&task_id=${encodeURIComponent(taskId)}&user_id=${encodeURIComponent(newUserId)}`;
    xhr.send(params);
}

function completedtasks() {
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    const taskSection = document.getElementById("task-status");
                    if (xhr.status === 200) {
                        taskSection.innerHTML = xhr.responseText;
                        showSection("task-status");
                    } else {
                        taskSection.innerHTML = `<p style="color: red;">Error fetching tasks. Please try again later.</p>`;
                        showSection("task-status");
                    }
                }
            };

            xhr.open("GET", `completedtask.do`, true);
            xhr.send();
        }
    </script>
</body>
</html>
        