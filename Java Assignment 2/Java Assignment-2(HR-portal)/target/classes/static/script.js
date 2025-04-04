document.addEventListener("DOMContentLoaded", function() {
    const user = sessionStorage.getItem("user");
    if (user) {
        document.getElementById("auth-buttons").style.display = "none";
        document.getElementById("employee-section").style.display = "block";
        fetchEmployees();
    }
});

document.getElementById("login-form")?.addEventListener("submit", function(event) {
    event.preventDefault();
    sessionStorage.setItem("user", "logged in");
    window.location.href = "index.html";
});

document.getElementById("register-form")?.addEventListener("submit", function(event) {
    event.preventDefault();
    alert("Registration successful! Please login.");
    window.location.href = "login.html";
});

function logout() {
    sessionStorage.removeItem("user");
    window.location.href = "index.html";
}

function fetchEmployees() {
    fetch("http://localhost:8080/emp")
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById("employee-table-body");
            tableBody.innerHTML = "";//clear previous entries

            //loop through each employee
            data.forEach(emp => {
                const row = `<tr>
                    <td>${emp.emp_id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.dept}</td>
                    <td>${emp.email}</td>
                    <td>${emp.salary}</td>
                    <td>
                          <button class="edit-btn" onclick="editEmployee(${emp.emp_id}, '${emp.name}', '${emp.dept}', '${emp.email}', ${emp.salary})">Edit</button>
                          <button class="delete-btn" onclick="deleteEmployee(${emp.emp_id})">Delete</button>
                    </td>
                </tr>`;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error("Error fetching employees:", error));
}


// Add Employee
document.getElementById("addEmpForm")?.addEventListener("submit", function (event) {
    event.preventDefault();

    const newEmployee = {
        name: document.getElementById("addName").value,
        dept: document.getElementById("addDept").value,
        email: document.getElementById("addEmail").value,
        salary: parseFloat(document.getElementById("addSalary").value)
    };

    fetch("http://localhost:8080/emp/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newEmployee)
    })
    .then(response =>{
     return response.json().then(data=>{
    if(!response.ok){
            throw new Error(data.message || "Something went wrong");
    }
    return data;
}).catch(() => {
          throw new Error("Invalid response from server");
     });
     })
    .then(data => {
        alert("Employee added successfully!");
        closeAddForm();
        fetchEmployees();
    })
    .catch(error => {
          showErrorPopup(error.message);
   });
});

function showAddForm() {
    document.getElementById("addFormContainer")?.classList.remove("hidden");
}

function closeAddForm() {
    document.getElementById("addFormContainer")?.classList.add("hidden");
}



// Function to Show Edit Form with Prefilled Data
function editEmployee(id, name, dept, email, salary) {
    document.getElementById("editEmpId").value = id;
    document.getElementById("editName").value = name;
    document.getElementById("editDept").value = dept;
    document.getElementById("editEmail").value = email;
    document.getElementById("editSalary").value = salary;

    document.getElementById("editFormContainer").classList.remove("hidden");
}

// Function to Close Edit Form
function closeEditForm() {
    document.getElementById("editFormContainer").classList.add("hidden");
}

// Function to Update Employee
document.getElementById("editEmpForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const empId = document.getElementById("editEmpId").value;
    const updatedEmp = {
        name: document.getElementById("editName").value,
        dept: document.getElementById("editDept").value,
        email: document.getElementById("editEmail").value,
        salary: parseFloat(document.getElementById("editSalary").value)
    };

    fetch(`http://localhost:8080/emp/${empId}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: new URLSearchParams(updatedEmp)
    })
    .then(response => response.json())
    .then(() => {
        closeEditForm();
        fetchEmployees(); // Refresh Employee List
    })
    .catch(error => console.error("Error updating employee:", error));
});

// Function to Delete Employee
function deleteEmployee(empId) {
    if (confirm("Are you sure you want to delete this employee?")) {
        fetch(`http://localhost:8080/emp/${empId}`, {
            method: "DELETE"
        })
        .then(() => fetchEmployees()) // Refresh Employee List
        .catch(error => console.error("Error deleting employee:", error));
    }
}

// Load Employees on Page Load
fetchEmployees();


//popup function
function showErrorPopup(message) {
    let popup = document.createElement("div");
    popup.classList.add("error-popup");
    popup.innerText = message;

    document.body.appendChild(popup);

    setTimeout(() => {
        popup.remove();
    }, 3000);
}
