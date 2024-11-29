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
            
        }],
    }
});

function toggleFullScreen() {
   var doc = window.document;
   var docEl = doc.documentElement;

   var requestFullScreen = docEl.requestFullscreen || docEl.mozRequestFullScreen || docEl.webkitRequestFullScreen || docEl.msRequestFullscreen;
   var cancelFullScreen = doc.exitFullscreen || doc.mozCancelFullScreen || doc.webkitExitFullscreen || doc.msExitFullscreen;

   if(!doc.fullscreenElement && !doc.mozFullScreenElement && !doc.webkitFullscreenElement && !doc.msFullscreenElement) {
       requestFullScreen.call(docEl);
   }
   else {
       cancelFullScreen.call(doc);
   }
}