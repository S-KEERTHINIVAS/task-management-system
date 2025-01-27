<html>
<head>
    <title>SIGNUP PAGE</title>
    <style>
        /* Body styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #333; /* Dark gray background */
            color: #f4f4f4; /* Light text color */
        }

        /* Center alignment for header and form */
        center {
            text-align: center;
            margin-top: 50px;
        }

        /* Header styling */
        u {
            font-size: 1.8em;
            color: #f4f4f4; /* Light gray for the underline */
        }

        /* Table styling */
        table {
            margin: auto;
            border-spacing: 10px;
        }

        td {
            padding: 10px;
            color: #f4f4f4; /* Light text for table cells */
        }

        label {
            font-size: 1em;
            font-weight: bold;
        }

        /* Input fields */
        input[type="number"],
        input[type="password"] {
            width: 200px;
            padding: 10px;
            border: 1px solid #444; /* Border in a slightly lighter gray */
            border-radius: 5px;
            background-color: #555; /* Input background */
            color: #f4f4f4; /* Text color */
        }

        input[type="number"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: #777; /* Slightly lighter border on focus */
            background-color: #666; /* Lighter gray on focus */
        }

        /* Button styling */
        button {
            width: 100px;
            padding: 10px;
            font-size: 1em;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            color: #f4f4f4; /* White text color */
            cursor: pointer;
            background-color: #555; /* Button gray background */
            transition: background-color 0.3s ease; /* Smooth hover effect */
        }

        button:hover {
            background-color: #777; /* Lighter gray on hover */
        }

        /* Special button for signup */
        button[type="submit"] {
            background-color: #d9534f; /* Red background */
            color: #f4f4f4; /* Light text */
        }

        button[type="submit"]:hover {
            background-color: #c9302c; /* Darker red on hover */
        }

        /* Responsive design for smaller screens */
        @media (max-width: 600px) {
            input[type="number"],
            input[type="password"] {
                width: 100%; /* Full width on small screens */
            }

            button {
                width: 100%; /* Full width buttons */
            }

            table {
                border-spacing: 5px; /* Smaller spacing */
            }
        }
    </style>
</head>
<body>
    <center>
        <form action="signin.do" method="POST">
            <table>
                <tr>
                    <td><label>ID:</label></td>
                    <td><input type="number" name="user_id" placeholder="Enter your ID"></td>
                </tr>
                <tr>
                    <td><label>Password:</label></td>
                    <td><input type="password" name="user_password" placeholder="Enter your password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <br>
                        <button type="submit">SIGNUP</button>
                        <br><br>
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
