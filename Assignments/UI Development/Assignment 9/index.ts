// import bootstrap from "bootstrap";

class Employee {
    empName: string = "";
    empGender: string = "";
    empEmail: string = "";
    empPassword: string = "";
    empContact: string = "";
    empId: string = "";
    empNameVal: boolean = false;
    empGenderVal: boolean = false;
    empEmailVal: boolean = false;
    empPasswordVal: boolean = false;
    empContactVal: boolean = false;
}

class Vehicle {
    empId: string = "";
    vehMake: string = "";
    vehModel: string = "";
    vehType: string = "";
    vehNumber: string = "";
    vehDesc: string = "";
    vehId: string = "";
    empIdVal: boolean = false;
    vehMakeVal: boolean = false;
    vehModelVal: boolean = false;
    vehTypeVal: boolean = false;
    vehNumberVal: boolean = false;
    vehDescVal: boolean = false;
}

let employees: Employee[] = [];
let vehicles: Vehicle[] = [];
let employee = new Employee();
let vehicle = new Vehicle();

let empFormInd = 0;
let vehFormInd = 0;


const saveEmpName = (): void => {
    const textField = document.getElementById("fname") as HTMLInputElement;
    const nameText = textField.value;
    const nameRegex = RegExp("^([a-zA-Z ]){3,30}$");
    if (nameRegex.test(nameText)) {
        textField.style.borderColor = "green";
        employee.empName = nameText;
        employee.empNameVal = true;
    } else {
        textField.style.borderColor = "red";
        employee.empNameVal = false;
    }
};

const saveEmpGender = (): void => {
    const gender = (document.querySelector('input[name="gender"]:checked') as HTMLInputElement).value;
    employee.empGenderVal = true;
    employee.empGender = gender;
};

const saveEmpEmail = (): void => {
    const textField = document.getElementById("email") as HTMLInputElement;
    const emailText = textField.value;
    const emailRegex = RegExp("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+[.]+[a-zA-Z0-9-.]+$");
    if (emailRegex.test(emailText)) {
        textField.style.borderColor = "green";
        employee.empEmail = emailText;
        employee.empEmailVal = true;
    } else {
        textField.style.borderColor = "red";
        employee.empEmailVal = false;
    }
};

const saveEmpContact = (): void => {
    const textField = document.getElementById("contact") as HTMLInputElement;
    const contactText = textField.value;
    const phoneRegex = RegExp("^([+]\\d{2}-)?\\d{10}$");
    if (phoneRegex.test(contactText)) {
        textField.style.borderColor = "green";
        employee.empContact = contactText;
        employee.empContactVal = true;
    } else {
        textField.style.borderColor = "red";
        employee.empContactVal = false;
    }
};

const saveEmpPassword1 = (): void => {
    const textField = document.getElementById("password") as HTMLInputElement;
    const passwordText = textField.value;
    const passwordRegex = RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    if (passwordRegex.test(passwordText)) {
        employee.empPassword = passwordText;
        textField.style.borderColor = passwordText.length > 12 ? "green" : "yellow";
    } else {
        textField.style.borderColor = "red";
    }
};

const saveEmpPassword2 = (): void => {
    const textField = document.getElementById("password2") as HTMLInputElement;
    const passwordText = textField.value;
    if (passwordText === employee.empPassword) {
        employee.empPasswordVal = true;
        textField.style.borderColor = "green";
    } else {
        textField.style.borderColor = "red";
        employee.empPasswordVal = false;
    }
};

const resetEmpForm = (): void => {
    document.getElementById("employeeField1")?.classList.toggle("d-none");
    document.getElementById("employeeField5")?.classList.toggle("d-none");
    employee.empContact = "";
    employee.empName = "";
    employee.empGender = "";
    employee.empEmail = "";
    employee.empPassword = "";

    ["fname", "email", "password", "password2", "contact"].forEach(id => {
        const field = document.getElementById(id) as HTMLInputElement;
        field.value = "";
        field.style.borderColor = "#ccc";
    });

    document.getElementById("empNextButton")?.classList.toggle("d-none");
    document.getElementById("submitEmpButton")?.classList.toggle("d-none");
    empFormInd = 0;
};

const submitEmpForm = (): void => {
    if (!employee.empContact) {
        alert("Please enter a proper 10 digit number");
        return;
    }
    const empIndex = employees.length;
    employee.empId = `Meta-Emp-${empIndex + 1}`;
    employees.push(employee);
    document.getElementById("empId")!.innerText = employee.empId;
    alert("ID: "+employee.empId);
    resetEmpForm();
    toggleEmpForm();
    toggleVehForm();
};

const employeeNext = (): void => {
    if (empFormInd === 0) {
        if (!employee.empName) {
            alert("Enter a proper name which contains alphabets only");
            return;
        }
        document.querySelector(".empName")!.innerHTML = employee.empName;
        document.getElementById("empNameLine")?.classList.toggle('d-none');
        document.getElementById("employeeField1")?.classList.toggle("d-none");
        document.getElementById("employeeField2")?.classList.toggle("d-none");
    } else if (empFormInd === 1) {
        if (!employee.empGender) {
            alert("Please select a gender");
            return;
        }
        const empField2 = document.getElementById("employeeField2");
        const empField3 = document.getElementById("employeeField3");
        document.getElementById("empNameLine")?.classList.toggle('d-none');
        empField2?.classList.toggle("d-none");
        empField3?.classList.toggle("d-none");
    } else if (empFormInd === 2) {
        if (!employee.empEmail) {
            alert("Please enter a proper email address");
            return;
        }
        const empField3 = document.getElementById("employeeField3");
        const empField4 = document.getElementById("employeeField4");
        empField3?.classList.toggle("d-none");
        empField4?.classList.toggle("d-none");
    } else if (empFormInd === 3) {
        if (!employee.empPassword) {
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

const saveVehEmpId = (): void => {
    const textField = <HTMLInputElement>document.getElementById("vehEmpID");
    const idText = textField.value;
    vehicle.empIdVal = idText.length > 5;
    if (vehicle.empIdVal) vehicle.empId = idText;
};

const saveVehMake = (): void => {
    const textField = <HTMLInputElement>document.getElementById("vehicleMake");
    const makeText = textField.value;
    vehicle.vehMakeVal = makeText.length > 3;
    if (vehicle.vehMake) vehicle.vehMake = makeText;
};

const saveVehModel = (): void => {
    const textField = <HTMLInputElement>document.getElementById("vehicleModel");
    const modelText = textField.value;
    vehicle.vehModelVal = modelText.length > 3;
    if (vehicle.vehModelVal) vehicle.vehModel = modelText;
};

const saveVehType = (): void => {
    const type = (<HTMLInputElement>document.querySelector('input[name="vehicleType"]:checked')).value;
    vehicle.vehTypeVal = true;
    vehicle.vehType = type;
};

const saveVehNumber = (): void => {
    const textField = <HTMLInputElement>document.getElementById("vehicleNumber");
    const numberText = textField.value;
    vehicle.vehNumberVal = numberText.length >= 6;
    if (vehicle.vehNumberVal) vehicle.vehNumber = numberText;
};

const saveVehIdentification = (): void => {
    const textField = <HTMLInputElement>document.getElementById("identification");
    const descText = textField.value;
    vehicle.vehDescVal = descText.length > 6;
    if (vehicle.vehDescVal) vehicle.vehDesc = descText;
};

const resetVehForm = (): void => {
    document.getElementById("vehicleField1")?.classList.toggle("d-none");
    document.getElementById("vehicleField6")?.classList.toggle("d-none");

    const fields: string[] = ["vehEmpID", "vehicleMake", "vehicleModel", "vehicleNumber", "identification"];
    fields.forEach(id => {
        const textField = <HTMLInputElement>document.getElementById(id);
        textField.value = "";
    });

    document.getElementById("vehNextButton")?.classList.toggle("d-none");
    document.getElementById("submitVehButton")?.classList.toggle("d-none");
    vehFormInd = 0;
};

const submitVehForm = (): void => {
    if (!vehicle.vehDescVal) {
        alert("Please enter some details about your vehicle for identification");
        return;
    }
    vehicle.vehId = `Meta-Veh-${vehicles.length + 1}`;
    vehicles.push(vehicle);
    document.getElementById("vehId")!.innerText = vehicle.vehId;

    alert("ID: "+vehicle.vehId);
    resetVehForm();
};

const vehicleNext = (): void => {
    switch (vehFormInd) {
        case 0:
            if (!vehicle.empIdVal) {
                alert("Enter a proper employee id");
                return;
            }
            const isEmpFound = employees.some(emp => emp.empId === vehicle.empId);
            if (!isEmpFound) {
                alert("No employee found with provided id");
                resetVehForm();
                return;
            }
            document.getElementById("vehicleField1")?.classList.toggle("d-none");
            document.getElementById("vehicleField2")?.classList.toggle("d-none");
            break;
        case 1:
            if (!vehicle.vehMakeVal) {
                alert("Please enter a proper brand name");
                return;
            }
            document.getElementById("vehicleField2")?.classList.toggle("d-none");
            document.getElementById("vehicleField3")?.classList.toggle("d-none");
            break;
        case 2:
            if (!vehicle.vehModelVal) {
                alert("Please enter a vehicle model");
                return;
            }
            document.getElementById("vehicleField3")?.classList.toggle("d-none");
            document.getElementById("vehicleField4")?.classList.toggle("d-none");
            break;
        case 3:
            if (!vehicle.vehTypeVal) {
                alert("Please select the type of your vehicle");
                return;
            }
            document.getElementById("vehicleField4")?.classList.toggle("d-none");
            document.getElementById("vehicleField5")?.classList.toggle("d-none");
            break;
        case 4:
            if (!vehicle.vehNumberVal) {
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
}

type CurrencyDetails = {
    currencyClass: string;
    cycleDaily: string;
    bikeDaily: string;
    carDaily: string;
    cycleMonthly: string;
    bikeMonthly: string;
    carMonthly: string;
    cycleYearly: string;
    bikeYearly: string;
    carYearly: string;
}

const saveCurrency = (currInd: number): void => {
    const currencyDetails: {[key:number]: CurrencyDetails} = {
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
    Array.from(collection).forEach((item) => (item as HTMLInputElement).checked = true);
    document.getElementById("cycleDaily")!.innerHTML = cycleDaily;
    document.getElementById("bikeDaily")!.innerHTML = bikeDaily;
    document.getElementById("carDaily")!.innerHTML = carDaily;
    document.getElementById("cycleMonthly")!.innerHTML = cycleMonthly;
    document.getElementById("bikeMonthly")!.innerHTML = bikeMonthly;
    document.getElementById("carMonthly")!.innerHTML = carMonthly;
    document.getElementById("cycleYearly")!.innerHTML = cycleYearly;
    document.getElementById("bikeYearly")!.innerHTML = bikeYearly;
    document.getElementById("carYearly")!.innerHTML = carYearly;
};

const expandPassForm = (param: number): void => {
    if (param === 1) {
        const collection = document.getElementsByClassName("cycleForm");
        Array.from(collection).forEach((item) => (item as HTMLInputElement).checked = true);
        document.getElementById("cyclePassDiv")!.classList.remove("d-none");
        document.getElementById("bikePassDiv")!.classList.add("d-none");
        document.getElementById("carPassDiv")!.classList.add("d-none");
        document.getElementById("cyclePassDiv")!.scrollIntoView({ behavior: 'smooth' });
    } else if (param === 2) {
        const collection = document.getElementsByClassName("bikeForm");
        Array.from(collection).forEach((item) => (item as HTMLInputElement).checked = true);
        document.getElementById("cyclePassDiv")!.classList.add("d-none");
        document.getElementById("bikePassDiv")!.classList.remove("d-none");
        document.getElementById("carPassDiv")!.classList.add("d-none");
        document.getElementById("bikePassDiv")!.scrollIntoView({ behavior: 'smooth' });
    } else if (param === 3) {
        const collection = document.getElementsByClassName("carForm");
        Array.from(collection).forEach((item) => (item as HTMLInputElement).checked = true);
        document.getElementById("cyclePassDiv")!.classList.add("d-none");
        document.getElementById("bikePassDiv")!.classList.add("d-none");
        document.getElementById("carPassDiv")!.classList.remove("d-none");
        document.getElementById("carPassDiv")!.scrollIntoView({ behavior: 'smooth' });
    }
};

const getCyclePass = (): void => {
    const currVehId = (document.getElementById("cycleVehID") as HTMLInputElement).value;
    const flag = vehicles.some(vehicle => vehicle.vehId === currVehId && vehicle.vehType === "Cycle");
    if (!flag) {
        alert("Please enter a valid vehicle id");
        return;
    }
    // const modal = new bootstrap.Modal(document.getElementById("passModal")!);
    // modal.show();
};

const getBikePass = (): void => {
    const currVehId = (document.getElementById("bikeVehID") as HTMLInputElement).value;
    const flag = vehicles.some(vehicle => vehicle.vehId === currVehId && vehicle.vehType === "MotorBike");
    if (!flag) {
        alert("Please enter a valid vehicle id");
        return;
    }
    // const modal = new bootstrap.Modal(document.getElementById("passModal")!);
    // modal.show();
};

const getCarPass = (): void => {
    const currVehId = (document.getElementById("carVehID") as HTMLInputElement).value;
    const flag = vehicles.some(vehicle => vehicle.vehId === currVehId && vehicle.vehType === "Car");
    if (!flag) {
        alert("Please enter a valid vehicle id");
        return;
    }
    // const modal = new bootstrap.Modal(document.getElementById("passModal")!);
    // modal.show();
};

const toggleEmpForm = (): void => {
    document.getElementById("addEmpForm")!.classList.toggle("d-none");
    document.getElementById("addVehForm")!.classList.add("d-none");
    document.getElementById("addEmployee")!.scrollIntoView({ behavior: 'smooth' });
};

const toggleVehForm = (): void => {
    document.getElementById("addVehForm")!.classList.toggle("d-none");
    document.getElementById("addEmpForm")!.classList.add("d-none");
    document.getElementById("addVehicle")!.scrollIntoView({ behavior: 'smooth' });
}