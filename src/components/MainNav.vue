<template>
    <nav class="navbar navbar-expand-sm bg-transparent fixed-top">
          <div class="container-fluid">
            <img src="src/img/Logomark.png" alt="Nomatic Logo">
            
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" style="background-color: #f5f5f5; color: black">
              <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              
              <ul class="navbar-nav mb-2 mb-lg-0 mx-auto">
                <li class="nav-item">
                  <a class="nav-link active" href="#" style="color: white;">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#" id="mat-finder-nav" style="color: white;">Mat Finder</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#" id="create-openmat-nav" style="color: white;">Create Openmat</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#" id="matchmaker-nav" style="color: white;">Match Maker</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#" id="profile-nav" style="color: white;">Profile</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#" id="faq-nav" style="color: white;">FAQ</a>
                </li>
                
              </ul>
      
            </div>
          </div>
        </nav>
</template>


<script>

</script>


<style scoped>
  /* NAV BAR SECTION */

.logo {
  height: 300px;
}

img {
  height: 100%;
}

nav {
  flex-grow: 1;
}

ul {
  margin: 0;
  padding: 0;
  list-style-type: none;
  display: flex;
  justify-content: center;
}

li {
  font-size: 16px;
  color: #ffffff;
  font-weight: 500;
  padding: 0 20px 0 0;
  margin-left: 20px;
}

a:hover {
  color: rgb(190, 190, 190);
}

a {
color: white;
text-decoration: none;
}
</style>