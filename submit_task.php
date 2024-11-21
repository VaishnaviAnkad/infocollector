<?php
$servername = "localhost";
$username = "root";
$password = "amuvaishu5";
$dbname = "taskmanagement123";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $taskName = $_POST['taskName'];
    $taskDescription = $_POST['taskDescription'];
    $taskDeadline = $_POST['taskDeadline'];
    $assigneeName = $_POST['assigneeName'];
    $assigneeEmail = $_POST['assigneeEmail'];

    // Handle file upload
    $filePath = null;
    if (!empty($_FILES['fileUpload']['name'])) {
        $targetDir = "uploads/";
        $filePath = $targetDir . basename($_FILES["fileUpload"]["name"]);
        move_uploaded_file($_FILES["fileUpload"]["tmp_name"], $filePath);
    }

    $sql = "INSERT INTO tasks (task_name, task_description, task_deadline, assignee_name, assignee_email, file_path) VALUES (?, ?, ?, ?, ?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ssssss", $taskName, $taskDescription, $taskDeadline, $assigneeName, $assigneeEmail, $filePath);

    if ($stmt->execute()) {
        echo "New record created successfully";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $stmt->close();
    $conn->close();
}
?>
