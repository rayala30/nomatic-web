<template>
    <div>
        
    </div>
</template>

<script>
export default {
    
}
</script>

<style>
body#index::before {
  content: "";
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display:flex;
  align-items: center; /* Center vertically */
  justify-content: center; /* Center horizontally */
  background-image: url(./img-css/rolling-image.png); /* Use the same image as the background */
  filter: grayscale(100%);
  background-blend-mode: luminosity; /* Adjust blend mode as needed */
  background-size: cover;
  background-repeat: no-repeat;
  max-width: 100%;
  background-position: 0% 75%;
}
    
</style>