<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
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
        .sidebar button {
            text-decoration: none;
            color: white;
            padding: 10px;
            background: #444;
            border-radius: 5px;
            border: none;
            text-align: center;
            cursor: pointer;
        }
        .sidebar button:hover {
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
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
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
        <h1>User Dashboard</h1>
    </header>
    <div class="container">  
        <div class="sidebar">
            <button onclick="fetchTasks()">Tasks</button>
            <button onclick="pendingTasks()">Task Responses (Pending)</button>
            <button onclick="completedTask()">Task Completed</button>
        </div>

        <div class="content">
            <!-- Tasks Section -->
            <div id="task" class="hidden">
                <h2>Tasks</h2>
                <!-- Task data will load here -->
            </div>

            <!-- Pending Tasks Section -->
            <div id="pending-tasks" class="hidden">
                
            </div>

            <!-- Task Completed Section -->
            <div id="task-status" class="hidden">
                
            </div>
        </div>
    </div>

    <script>
        function fetchTasks() {
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    const taskSection = document.getElementById("task");
                    if (xhr.status === 200) {
                        taskSection.innerHTML = xhr.responseText;
                        showSection("task");
                    } else {
                        taskSection.innerHTML = `<p style="color: red;">Error fetching tasks. Please try again later.</p>`;
                        showSection("task");
                    }
                }
            };

            xhr.open("GET", `fetchTasksServlet.do`, true);
            xhr.send();
        }
        function pendingTasks() {
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    const taskSection = document.getElementById("task");
                    if (xhr.status === 200) {
                        taskSection.innerHTML = xhr.responseText;
                        showSection("task");
                    } else {
                        taskSection.innerHTML = `<p style="color: red;">No task.</p>`;
                        showSection("task");
                    }
                }
            };

            xhr.open("GET", `pendingTasksServlet.do`, true);
            xhr.send();
        }

        function completedTask() {
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    const taskSection = document.getElementById("task");
                    if (xhr.status === 200) {
                        taskSection.innerHTML = xhr.responseText;
                        showSection("task");
                    } else {
                        taskSection.innerHTML = `<p style="color: red;">Error fetching tasks. Please try again later.</p>`;
                        showSection("task");
                    }
                }
            };

            xhr.open("GET", `taskcompletedServlet.do`, true);
            xhr.send();
        }

        function showSection(sectionId) {
            const sections = document.querySelectorAll('.content > div');
            sections.forEach((section) => section.classList.add('hidden'));

            const section = document.getElementById(sectionId);
            if (section) {
                section.classList.remove('hidden');
            }
        }

        document.addEventListener("DOMContentLoaded", () => {
            fetchTasks(); 
        });
    </script>
    <script>
            function acceptTask(taskid) {
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    alert("Task Accepted!");
                    location.reload();
                }
            };
            xhr.open("POST", "acceptTaskServlet.do", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(`task_id=${taskid}`);
        }
        function completeTask(taskid) {
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    alert("Task Completed!");
                    location.reload();
                }
            };
            xhr.open("POST", "CompleteTaskServlet.do", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(`task_id=${taskid}`);
        }
    
        // Show rejection reason field
        function showRejectReason(taskid) {
            const rejectDiv = document.getElementById(`reject-reason-${taskid}`);
            rejectDiv.style.display = "block";
        }
    
        // Submit Rejection
        function submitRejection(taskid) {
            const reason = document.getElementById(`reason-${taskid}`).value;
            if (!reason.trim()) {
                alert("Please enter a rejection reason.");
                return;
            }
    
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    alert("Task Rejected!");
                    location.reload();
                }
            };
            xhr.open("POST", "rejectTaskServlet.do", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(`task_id=${taskid}&reason=${encodeURIComponent(reason)}`);
        }
    </script>
    
</body>
</html>
