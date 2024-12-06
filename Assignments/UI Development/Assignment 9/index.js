"use strict";
// import bootstrap from "bootstrap";
let employees = [];
let vehicles = [];
let empFormInd = 0;
let vehFormInd = 0;
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
const vehicleDetails = {
    empId: "",
    vehMake: "",
    vehModel: "",
    vehType: "",
    vehNumber: "",
    vehDesc: "",
    vehId: ""
};
const vehicleDetailsValidated = {
    empId: false,
    vehMake: false,
    vehModel: false,
    vehType: false,
    vehNumber: false,
    vehDesc: false
};
// Functions
const saveEmpName = () => {
    const textField = document.getElementById("fname");
    const nameText = textField.value;
    const nameRegex = RegExp("^([a-zA-Z ]){3,30}$");
    if (nameRegex.test(nameText)) {
        textField.style.borderColor = "green";
        empDetails.empName = nameText;
        empDetailsValidated.empName = true;
    }
    else {
        textField.style.borderColor = "red";
        empDetailsValidated.empName = false;
    }
};
const saveEmpGender = () => {
    const gender = document.querySelector('input[name="gender"]:checked').value;
    empDetailsValidated.empGender = true;
    empDetails.empGender = gender;
};
const saveEmpEmail = () => {
    const textField = document.getElementById("email");
    const emailText = textField.value;
    const emailRegex = RegExp("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+[.]+[a-zA-Z0-9-.]+$");
    if (emailRegex.test(emailText)) {
        textField.style.borderColor = "green";
        empDetails.empEmail = emailText;
        empDetailsValidated.empEmail = true;
    }
    else {
        textField.style.borderColor = "red";
        empDetailsValidated.empEmail = false;
    }
};
const saveEmpContact = () => {
    const textField = document.getElementById("contact");
    const contactText = textField.value;
    const phoneRegex = RegExp("^([+]\\d{2}-)?\\d{10}$");
    if (phoneRegex.test(contactText)) {
        textField.style.borderColor = "green";
        empDetails.empContact = contactText;
        empDetailsValidated.empContact = true;
    }
    else {
        textField.style.borderColor = "red";
        empDetailsValidated.empContact = false;
    }
};
const saveEmpPassword1 = () => {
    const textField = document.getElementById("password");
    const passwordText = textField.value;
    const passwordRegex = RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    if (passwordRegex.test(passwordText)) {
        empDetails.empPassword = passwordText;
        textField.style.borderColor = passwordText.length > 12 ? "green" : "yellow";
    }
    else {
        textField.style.borderColor = "red";
    }
};
const saveEmpPassword2 = () => {
    const textField = document.getElementById("password2");
    const passwordText = textField.value;
    if (passwordText === empDetails.empPassword) {
        empDetailsValidated.empPassword = true;
        textField.style.borderColor = "green";
    }
    else {
        textField.style.borderColor = "red";
        empDetailsValidated.empPassword = false;
    }
};
const resetEmpForm = () => {
    document.getElementById("employeeField1")?.classList.toggle("d-none");
    document.getElementById("employeeField5")?.classList.toggle("d-none");
    empDetails.empContact = "";
    empDetails.empName = "";
    empDetails.empGender = "";
    empDetails.empEmail = "";
    empDetails.empPassword = "";
    Object.keys(empDetailsValidated).forEach(key => empDetailsValidated[key] = false);
    ["fname", "email", "password", "password2", "contact"].forEach(id => {
        const field = document.getElementById(id);
        field.value = "";
        field.style.borderColor = "#ccc";
    });
    document.getElementById("empNextButton")?.classList.toggle("d-none");
    document.getElementById("submitEmpButton")?.classList.toggle("d-none");
    empFormInd = 0;
};
const submitEmpForm = () => {
    if (!empDetailsValidated.empContact) {
        alert("Please enter a proper 10 digit number");
        return;
    }
    // if (!Object.values(empDetailsValidated).every(valid => valid)) {
    //     document.getElementById("empModalMessageSuccess")?.classList.toggle("d-none");
    //     document.getElementById("empModalMessageFailed")?.classList.toggle("d-none");
    //     resetEmpForm();
    //     return;
    // }
    const empIndex = employees.length;
    empDetails.empId = `Meta-Emp-${empIndex + 1}`;
    employees.push(empDetails);
    document.getElementById("empId").innerText = empDetails.empId;
    // const modal = new bootstrap.Modal(document.getElementById("addEmpModal")!);
    // modal.show();
    resetEmpForm();
    toggleEmpForm();
    toggleVehForm();
};
const employeeNext = () => {
    if (empFormInd === 0) {
        if (!empDetailsValidated.empName) {
            alert("Enter a proper name which contains alphabets only");
            return;
        }
        document.querySelector(".empName").innerHTML = empDetails.empName;
        document.getElementById("empNameLine")?.classList.toggle('d-none');
        document.getElementById("employeeField1")?.classList.toggle("d-none");
        document.getElementById("employeeField2")?.classList.toggle("d-none");
    }
    else if (empFormInd === 1) {
        if (!empDetailsValidated.empGender) {
            alert("Please select a gender");
            return;
        }
        const empField2 = document.getElementById("employeeField2");
        const empField3 = document.getElementById("employeeField3");
        document.getElementById("empNameLine")?.classList.toggle('d-none');
        empField2?.classList.toggle("d-none");
        empField3?.classList.toggle("d-none");
    }
    else if (empFormInd === 2) {
        if (!empDetailsValidated.empEmail) {
            alert("Please enter a proper email address");
            return;
        }
        const empField3 = document.getElementById("employeeField3");
        const empField4 = document.getElementById("employeeField4");
        empField3?.classList.toggle("d-none");
        empField4?.classList.toggle("d-none");
    }
    else if (empFormInd === 3) {
        if (!empDetailsValidated.empPassword) {
            alert("Both passwords should match and must contain at least one uppercase, one lowercase, one special symbol, and one number");
            return;
        }
        const empField4 = document.getElementById("employeeField4");
        const empField5 = document.getElementById("employeeField5");
        document.getElementById("empNextButton")?.classList.toggle("d-none");
        document.getElementById("submitEmpButton")?.classList.toggle("d-none");
        empField4?.classList.toggle("d-none");
        empField5?.classList.toggle("d-none");
    }
    empFormInd++;
};
const saveVehEmpId = () => {
    const textField = document.getElementById("vehEmpID");
    const idText = textField.value;
    vehicleDetailsValidated.empId = idText.length > 5;
    if (vehicleDetailsValidated.empId)
        vehicleDetails.empId = idText;
};
const saveVehMake = () => {
    const textField = document.getElementById("vehicleMake");
    const makeText = textField.value;
    vehicleDetailsValidated.vehMake = makeText.length > 3;
    if (vehicleDetailsValidated.vehMake)
        vehicleDetails.vehMake = makeText;
};
const saveVehModel = () => {
    const textField = document.getElementById("vehicleModel");
    const modelText = textField.value;
    vehicleDetailsValidated.vehModel = modelText.length > 3;
    if (vehicleDetailsValidated.vehModel)
        vehicleDetails.vehModel = modelText;
};
const saveVehType = () => {
    const type = document.querySelector('input[name="vehicleType"]:checked').value;
    vehicleDetailsValidated.vehType = true;
    vehicleDetails.vehType = type;
};
const saveVehNumber = () => {
    const textField = document.getElementById("vehicleNumber");
    const numberText = textField.value;
    vehicleDetailsValidated.vehNumber = numberText.length >= 6;
    if (vehicleDetailsValidated.vehNumber)
        vehicleDetails.vehNumber = numberText;
};
const saveVehIdentification = () => {
    const textField = document.getElementById("identification");
    const descText = textField.value;
    vehicleDetailsValidated.vehDesc = descText.length > 6;
    if (vehicleDetailsValidated.vehDesc)
        vehicleDetails.vehDesc = descText;
};
const resetVehForm = () => {
    document.getElementById("vehicleField1")?.classList.toggle("d-none");
    document.getElementById("vehicleField6")?.classList.toggle("d-none");
    // Reset vehicle details
    Object.keys(vehicleDetails).forEach((key) => vehicleDetails[key] = "");
    // Object.keys(vehicleDetailsValidated).forEach((key) => vehicleDetailsValidated[key as keyof VehicleDetails] = false);
    const fields = ["vehEmpID", "vehicleMake", "vehicleModel", "vehicleNumber", "identification"];
    fields.forEach(id => {
        const textField = document.getElementById(id);
        textField.value = "";
    });
    document.getElementById("vehNextButton")?.classList.toggle("d-none");
    document.getElementById("submitVehButton")?.classList.toggle("d-none");
    vehFormInd = 0;
};
const submitVehForm = () => {
    if (!vehicleDetailsValidated.vehDesc) {
        alert("Please enter some details about your vehicle for identification");
        return;
    }
    // if (!Object.values(vehicleDetailsValidated).every(valid => valid)) {
    //     document.getElementById("vehModalMessageSuccess")?.classList.toggle("d-none");
    //     document.getElementById("vehModalMessageFailed")?.classList.toggle("d-none");
    //     resetVehForm();
    //     return;
    // }
    vehicleDetails.vehId = `Meta-Veh-${vehicles.length + 1}`;
    vehicles.push(vehicleDetails);
    document.getElementById("vehId").innerText = vehicleDetails.vehId;
    // const modal = new bootstrap.Modal(document.getElementById("addVehModal")!);
    // modal.show();
    resetVehForm();
};
const vehicleNext = () => {
    switch (vehFormInd) {
        case 0:
            if (!vehicleDetailsValidated.empId) {
                alert("Enter a proper employee id");
                return;
            }
            const isEmpFound = employees.some(emp => emp.empId === vehicleDetails.empId);
            if (!isEmpFound) {
                alert("No employee found with provided id");
                resetVehForm();
                return;
            }
            document.getElementById("vehicleField1")?.classList.toggle("d-none");
            document.getElementById("vehicleField2")?.classList.toggle("d-none");
            break;
        case 1:
            if (!vehicleDetailsValidated.vehMake) {
                alert("Please enter a proper brand name");
                return;
            }
            document.getElementById("vehicleField2")?.classList.toggle("d-none");
            document.getElementById("vehicleField3")?.classList.toggle("d-none");
            break;
        case 2:
            if (!vehicleDetailsValidated.vehModel) {
                alert("Please enter a vehicle model");
                return;
            }
            document.getElementById("vehicleField3")?.classList.toggle("d-none");
            document.getElementById("vehicleField4")?.classList.toggle("d-none");
            break;
        case 3:
            if (!vehicleDetailsValidated.vehType) {
                alert("Please select the type of your vehicle");
                return;
            }
            document.getElementById("vehicleField4")?.classList.toggle("d-none");
            document.getElementById("vehicleField5")?.classList.toggle("d-none");
            break;
        case 4:
            if (!vehicleDetailsValidated.vehNumber) {
                alert("Please enter a valid vehicle number");
                return;
            }
            document.getElementById("vehicleField5")?.classList.toggle("d-none");
            document.getElementById("vehicleField6")?.classList.toggle("d-none");
            document.getElementById("vehNextButton")?.classList.toggle("d-none");
            document.getElementById("submitVehButton")?.classList.toggle("d-none");
            break;
    }
    vehFormInd++;
};
const saveCurrency = (currInd) => {
    const currencyDetails = {
        1: {
            currencyClass: "currUsd",
            cycleDaily: "5 USD/Daily", bikeDaily: "10 USD/Daily", carDaily: "20 USD/Daily",
            cycleMonthly: "100 USD/Monthly", bikeMonthly: "200 USD/Monthly", carMonthly: "500 USD/Monthly",
            cycleYearly: "500 USD/Yearly", bikeYearly: "1000 USD/Yearly", carYearly: "3500 USD/Yearly"
        },
        2: {
            currencyClass: "currInr",
            cycleDaily: "425 INR/Daily", bikeDaily: "850 INR/Daily", carDaily: "1700 INR/Daily",
            cycleMonthly: "8500 INR/Monthly", bikeMonthly: "17000 INR/Monthly", carMonthly: "42000 INR/Monthly",
            cycleYearly: "42000 INR/Yearly", bikeYearly: "84000 INR/Yearly", carYearly: "300000 INR/Yearly"
        },
        3: {
            currencyClass: "currYen",
            cycleDaily: "750 YEN/Daily", bikeDaily: "1500 YEN/Daily", carDaily: "3000 YEN/Daily",
            cycleMonthly: "15000 YEN/Monthly", bikeMonthly: "30000 YEN/Monthly", carMonthly: "75000 YEN/Monthly",
            cycleYearly: "75000 YEN/Yearly", bikeYearly: "150000 YEN/Yearly", carYearly: "500000 YEN/Yearly"
        }
    };
    const { currencyClass, cycleDaily, bikeDaily, carDaily, cycleMonthly, bikeMonthly, carMonthly, cycleYearly, bikeYearly, carYearly } = currencyDetails[currInd];
    const collection = document.getElementsByClassName(currencyClass);
    Array.from(collection).forEach((item) => item.checked = true);
    document.getElementById("cycleDaily").innerHTML = cycleDaily;
    document.getElementById("bikeDaily").innerHTML = bikeDaily;
    document.getElementById("carDaily").innerHTML = carDaily;
    document.getElementById("cycleMonthly").innerHTML = cycleMonthly;
    document.getElementById("bikeMonthly").innerHTML = bikeMonthly;
    document.getElementById("carMonthly").innerHTML = carMonthly;
    document.getElementById("cycleYearly").innerHTML = cycleYearly;
    document.getElementById("bikeYearly").innerHTML = bikeYearly;
    document.getElementById("carYearly").innerHTML = carYearly;
};
const expandPassForm = (param) => {
    if (param === 1) {
        const collection = document.getElementsByClassName("cycleForm");
        Array.from(collection).forEach((item) => item.checked = true);
        document.getElementById("cyclePassDiv").classList.remove("d-none");
        document.getElementById("bikePassDiv").classList.add("d-none");
        document.getElementById("carPassDiv").classList.add("d-none");
        document.getElementById("cyclePassDiv").scrollIntoView({ behavior: 'smooth' });
    }
    else if (param === 2) {
        const collection = document.getElementsByClassName("bikeForm");
        Array.from(collection).forEach((item) => item.checked = true);
        document.getElementById("cyclePassDiv").classList.add("d-none");
        document.getElementById("bikePassDiv").classList.remove("d-none");
        document.getElementById("carPassDiv").classList.add("d-none");
        document.getElementById("bikePassDiv").scrollIntoView({ behavior: 'smooth' });
    }
    else if (param === 3) {
        const collection = document.getElementsByClassName("carForm");
        Array.from(collection).forEach((item) => item.checked = true);
        document.getElementById("cyclePassDiv").classList.add("d-none");
        document.getElementById("bikePassDiv").classList.add("d-none");
        document.getElementById("carPassDiv").classList.remove("d-none");
        document.getElementById("carPassDiv").scrollIntoView({ behavior: 'smooth' });
    }
};
const getCyclePass = () => {
    const currVehId = document.getElementById("cycleVehID").value;
    const flag = vehicles.some(vehicle => vehicle.vehId === currVehId && vehicle.vehType === "Cycle");
    if (!flag) {
        alert("Please enter a valid vehicle id");
        return;
    }
    // const modal = new bootstrap.Modal(document.getElementById("passModal")!);
    // modal.show();
};
const getBikePass = () => {
    const currVehId = document.getElementById("bikeVehID").value;
    const flag = vehicles.some(vehicle => vehicle.vehId === currVehId && vehicle.vehType === "MotorBike");
    if (!flag) {
        alert("Please enter a valid vehicle id");
        return;
    }
    // const modal = new bootstrap.Modal(document.getElementById("passModal")!);
    // modal.show();
};
const getCarPass = () => {
    const currVehId = document.getElementById("carVehID").value;
    const flag = vehicles.some(vehicle => vehicle.vehId === currVehId && vehicle.vehType === "Car");
    if (!flag) {
        alert("Please enter a valid vehicle id");
        return;
    }
    // const modal = new bootstrap.Modal(document.getElementById("passModal")!);
    // modal.show();
};
const toggleEmpForm = () => {
    document.getElementById("addEmpForm").classList.toggle("d-none");
    document.getElementById("addVehForm").classList.add("d-none");
    document.getElementById("addEmployee").scrollIntoView({ behavior: 'smooth' });
};
const toggleVehForm = () => {
    document.getElementById("addVehForm").classList.toggle("d-none");
    document.getElementById("addEmpForm").classList.add("d-none");
    document.getElementById("addVehicle").scrollIntoView({ behavior: 'smooth' });
};
