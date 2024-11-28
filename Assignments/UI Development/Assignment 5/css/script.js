let navBar = document.getElementById("side_nav");
let navBarButton = document.getElementById("nav_hamburger");
let navIsOpen = true;
navBarButton.addEventListener("click", ()=>{
    navIsOpen = !navIsOpen;
    if(navIsOpen){
        navBar.style.display = "block";
    }else{
        navBar.style.display = "none";
    }
});

