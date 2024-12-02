let employees = [];
let vehicles = [];

var empFormInd = 0;
var vehFormInd = 0;



// Employee Form Methods

const empDetails = {
    empName: "",
    empGender: "",
    empEmail: "",
    empPassword: "",
    empContact: "",
    empId: ""
};

const empDetailsValidated = {
    empName: false,
    empGender: false,
    empEmail: false,
    empPassword: false,
    empContact: false
};


function saveEmpName() {
    let textField = document.getElementById("fname");
    let nameText = textField.value;
    const nameRegex = RegExp("^([a-zA-Z ]){3,30}$");
    if(nameRegex.test(nameText)){
        textField.style.borderColor = "green"
        empDetails.empName = nameText;
        empDetailsValidated.empName = true;
    } else {
        textField.style.borderColor = "red"
        empDetailsValidated.empName = false;
    }
}

function saveEmpGender() {
    let gender = document.querySelector('input[name = gender]:checked').value;
    empDetailsValidated.empGender = true;
    empDetails.empGender = gender;
}

function saveEmpEmail() {
    let textField = document.getElementById("email");
    let emailText = textField.value;
    const emailRegex = RegExp("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+[.]+[a-zA-Z0-9-.]+$");
    if(emailRegex.test(emailText)){
        textField.style.borderColor = "green"
        empDetails.empEmail = emailText;
        empDetailsValidated.empEmail = true;
    } else {
        textField.style.borderColor = "red"
        empDetailsValidated.empEmail = false;
    }
}

function saveEmpContact() {
    let textField = document.getElementById("contact");
    let contactText = textField.value;
    const phoneRegex = RegExp("^([+]\\d{2}-)?\\d{10}$");
    if(phoneRegex.test(contactText)){
        textField.style.borderColor = "green"
        empDetails.empContact = contactText;
        empDetailsValidated.empContact = true;
    } else {
        textField.style.borderColor = "red"
        empDetailsValidated.empContact = false;
    }
}

function saveEmpPassword1() {
    let textField = document.getElementById("password");    
    let passwordText = textField.value;
    const passwordRegex =  RegExp("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    if(passwordRegex.test(passwordText)){
        empDetails.empPassword = passwordText;
        if(passwordText.length > 12){
            textField.style.borderColor = "green"
        } else {
            textField.style.borderColor = "yellow"
        }
    } else {
        textField.style.borderColor = "red"
    }
}

function saveEmpPassword2() {
    let textField = document.getElementById("password2");    
    let passwordText = textField.value;
    if(passwordText === empDetails.empPassword){
        empDetailsValidated.empPassword = true;
        textField.style.borderColor = "green"
    } else {
        textField.style.borderColor = "red"
        empDetailsValidated.empPassword = false;
    }
}

function resetEmpForm() {
    document.getElementById("employeeField1").classList.toggle("d-none");
    document.getElementById("employeeField5").classList.toggle("d-none");
    empDetails.empContact = "";
    empDetails.empName = "";
    empDetails.empGender = "";
    empDetails.empEmail = "";
    empDetails.empPassword = "";
    empDetailsValidated.empContact = false;
    empDetailsValidated.empName = false;
    empDetailsValidated.empEmail = false;
    empDetailsValidated.empPassword = false;
    let nameTextField = document.getElementById("fname");
    nameTextField.value = "";
    nameTextField.style.borderColor = "#ccc";
    let emailTextField = document.getElementById("email");
    emailTextField.value = "";
    emailTextField.style.borderColor = "#ccc";
    let passwordTextField = document.getElementById("password");
    passwordTextField.value = "";
    passwordTextField.style.borderColor = "#ccc";
    let password2TextField = document.getElementById("password2");
    password2TextField.value = "";
    password2TextField.style.borderColor = "#ccc";
    let contactTextField = document.getElementById("contact");
    contactTextField.value = "";
    contactTextField.style.borderColor = "#ccc";
    document.getElementById("empNextButton").classList.toggle("d-none");
    document.getElementById("submitButton").classList.toggle("d-none");
    empFormInd = 0;
}

function submitEmpForm() {
    if(!empDetailsValidated.empContact){
        alert("Please enter a proper 10 digit number");
        return;
    }
    if(!empDetailsValidated.empContact || !empDetailsValidated.empEmail || !empDetailsValidated.empGender || !empDetailsValidated.empName || !empDetailsValidated.empPassword) {
        document.getElementById("empModalMessageSuccess").classList.toggle("d-none");
        document.getElementById("empModalMessageFailed").classList.toggle("d-none");
        resetEmpForm();
        return;
    }
    resetEmpForm();
    let empIndex = employees.length;
    empDetails.empId = "Meta-Emp-" + (empIndex+1);
    employees.push(empDetails);
    document.getElementById("empId").innerText = empDetails.empId;
    let modal = new bootstrap.Modal(document.getElementById("addEmpModal"));
    modal.show();
}

function employeeNext() {
    if(empFormInd == 0){
        if(empDetailsValidated.empName == false){
            alert("Enter a proper name which contains alphabets only");
            return;
        }
        document.getElementsByClassName("empName")[0].innerHTML = empDetails.empName;
        document.getElementById("empNameLine").classList.toggle('d-none');
        document.getElementById("employeeField1").classList.toggle("d-none");
        document.getElementById("employeeField2").classList.toggle("d-none");
    } else if(empFormInd == 1){
        if(empDetailsValidated.empGender == false) {
            alert("Please select a gender");
            return;
        }
        let empField2 = document.getElementById("employeeField2");
        let empField3 = document.getElementById("employeeField3");
        document.getElementById("empNameLine").classList.toggle('d-none');
        empField2.classList.toggle("d-none");
        empField3.classList.toggle("d-none");
    } else if(empFormInd == 2){
        if(empDetailsValidated.empEmail == false) {
            alert("Pleaes enter a proper email address");
            return;
        }
        let empField3 = document.getElementById("employeeField3");
        let empField4 = document.getElementById("employeeField4");
        empField3.classList.toggle("d-none");
        empField4.classList.toggle("d-none");
    } else if(empFormInd == 3){
        if(empDetailsValidated.empPassword== false) {
            alert("Both passwords should match and must contains at least one uppercase, one lowercase, one special symbol and one number");
            return;
        }
        let empField4 = document.getElementById("employeeField4");
        let empField5 = document.getElementById("employeeField5");
        document.getElementById("empNextButton").classList.toggle("d-none");
        document.getElementById("submitButton").classList.toggle("d-none");
        empField4.classList.toggle("d-none");
        empField5.classList.toggle("d-none");
    }
    empFormInd++;
}



// Vehicle Form Methods


const vehicleDetails = {
    empId: "",
    vehMake: "",
    vehModel: "",
    vehType: "",
    vehNumber: "",
    vehDesc: ""
};

const vehicleDetailsValidated = {
    empId:false,
    vehMake:false,
    vehModel:false,
    vehType:false,
    vehNumber:false,
    vehDesc:false
};

function saveVehEmpId() {
    let textField = document.getElementById("vehEmpID");
    let idText = textField.value;
    if(idText.length > 5){
        vehicleDetails.empId = idText;
        vehicleDetailsValidated.empId = true;
    } else {
        vehicleDetailsValidated.empId = false;
    }
}

function saveVehMake() {
    let textField = document.getElementById("vehicleMake");
    let makeText = textField.value;
    if(makeText.length > 3){
        vehicleDetails.empId = makeText;
        vehicleDetailsValidated.vehMake = true;
    } else {
        vehicleDetailsValidated.vehMake = false;
    }
}

function saveVehModel() {
    let textField = document.getElementById("vehicleModel");
    let modelText = textField.value;
    if(modelText.length > 3){
        vehicleDetails.vehModel = modelText;
        vehicleDetailsValidated.vehModel = true;
    } else {
        vehicleDetailsValidated.vehModel = false;
    }
}

function saveVehType() {
    let type = document.querySelector('input[name = vehicleType]:checked').value;
    vehicleDetailsValidated.vehType = true;
    vehicleDetails.vehType = type;
}

function saveVehNumber() {
    let textField = document.getElementById("vehicleNumber");
    let numberText = textField.value;
    if(numberText.length >= 6){
        vehicleDetails.vehNumber = numberText;
        vehicleDetailsValidated.vehNumber = true;
    } else {
        vehicleDetailsValidated.vehNumber = false;
    }
}

function saveVehIdentification() {
    let textField = document.getElementById("identification");
    let descText = textField.value;
    if(descText.length > 6){
        vehicleDetails.vehDesc = descText;
        vehicleDetailsValidated.vehDesc = true;
    } else {
        vehicleDetailsValidated.vehDesc = false;
    }   
}

function submitVehForm() {
    if(!vehicleDetailsValidated.vehDesc){
        alert("Please enter a some details about your vehicle for identification");
        return;
    }
    if(!vehicleDetailsValidated.vehMake || !vehicleDetailsValidated.vehModel || !vehicleDetailsValidated.vehNumber || !vehicleDetailsValidated.vehType || !vehicleDetailsValidated.empId || !vehicleDetailsValidated.vehDesc) {
        document.getElementById("empModalMessageSuccess").classList.toggle("d-none");
        document.getElementById("empModalMessageFailed").classList.toggle("d-none");
        resetVehForm();
        return;
    }
    resetVehForm();
    let empIndex = employees.length;
    empDetails.empId = "Meta-Emp-" + (empIndex+1);
    employees.push(empDetails);
    document.getElementById("empId").innerText = empDetails.empId;
    let modal = new bootstrap.Modal(document.getElementById("addEmpModal"));
    modal.show();
}

function vehicleNext() {
    if(vehFormInd == 0){
        if(empDetailsValidated.empId == false){
            alert("Enter a proper employee id");
            return;
        }
        // let isEmpFound = false;
        // for(let i = 0; i < employees.length; i++){
        //     if(employees[i].empId == vehicleDetails.empId) isEmpFound = true;
        // }
        // if(!isEmpFound){
        //     alert("No employee found with provided id");
        //     reset();
        //     return;
        // }
        document.getElementById("vehicleField1").classList.toggle("d-none");
        document.getElementById("vehicleField2").classList.toggle("d-none");
    } else if(vehFormInd == 1){
        if(vehicleDetailsValidated.vehMake == false) {
            alert("Please enter a proper brand name");
            return;
        }
        let vehField2 = document.getElementById("vehicleField2");
        let vehField3 = document.getElementById("vehicleField3");
        vehField2.classList.toggle("d-none");
        vehField3.classList.toggle("d-none");
    } else if(vehFormInd == 2){
        if(vehicleDetailsValidated.vehModel == false) {
            alert("Pleaes enter a vehicle model");
            return;
        }
        let vehField3 = document.getElementById("vehicleField3");
        let vehField4 = document.getElementById("vehicleField4");
        vehField3.classList.toggle("d-none");
        vehField4.classList.toggle("d-none");
    } else if(vehFormInd == 3){
        if(vehicleDetailsValidated.vehType == false) {
            alert("Please select the type of your vehicle");
            return;
        }
        let vehField4 = document.getElementById("vehicleField4");
        let vehField5 = document.getElementById("vehicleField5");
        vehField4.classList.toggle("d-none");
        vehField5.classList.toggle("d-none");
    } else if(vehFormInd == 4){
        if(vehicleDetailsValidated.vehNumber == false) {
            alert("Please enter a valid vehicle number");
            return;
        }
        let vehField5 = document.getElementById("vehicleField5");
        let vehField6 = document.getElementById("vehicleField6");
        document.getElementById("vehNextButton").classList.toggle("d-none");
        document.getElementById("submitVehButton").classList.toggle("d-none");
        vehField5.classList.toggle("d-none");
        vehField6.classList.toggle("d-none");
    }
    vehFormInd++;
}