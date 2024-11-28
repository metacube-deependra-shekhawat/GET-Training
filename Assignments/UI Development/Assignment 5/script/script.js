let navBar = document.getElementById("sideBar");
let navBarButton = document.getElementById("nav_hamburger");
let isExpanded = true;
navBarButton.addEventListener("click", ()=>{
    isExpanded = !isExpanded;
    if(isExpanded){
        navBar.style.display = "block";
    }else{
        navBar.style.display = "none";
    }
});


let ctx = document.getElementById("chart"); 
let myChart = new Chart(ctx, { 
    type: 'doughnut', 
    data: { 
        labels: [
            'Completed',
            'In-progress',
            'Behind'
        ],
        datasets: [{ 
            data: [64, 26, 10], 
            backgroundColor: ['rgb(80, 200, 80)', 
                              'rgb(54, 162, 235)', 
                              'rgb(255, 86, 86)', 
                            ], 
            
        }] 
    } 
});