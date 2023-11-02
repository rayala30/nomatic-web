<template>
    <main id="home-grid">
      <div id="logo">
        <img src="../img/logo-gold.svg" alt="Nomatic Logo">
      </div>

      <div id="create-acct-button">  
          <button id="yellow-button" type="button">
            <div class="button-label">
              <div id="create-acct-label">Create an account</div>
            </div>
          </button>  
        </div>

        <div id="log-in-button">  
          <button id="white-button" type="button">
            <div class="button-label">
              <div id="log-in-label">Log in</div>
            </div>
          </button>
        </div>

      <div id="nomatic">NOMATIC</div>

      <div id="phonetic">[ no • mat • ic ]</div>

      <div id="greeting-1">Find an open mat near you.</div>
        
      <div id="greeting-2">Get rolling!</div>
    </main>
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
  background-image: url('@/css/img-css/rolling-image.png'); /* Use the same image as the background */
  filter: grayscale(100%);
  background-blend-mode: luminosity; /* Adjust blend mode as needed */
  background-size: cover;
  background-repeat: no-repeat;
  max-width: 100%;
  background-position: 0% 75%;
}


#home-grid {
display: grid;
grid-template-columns: 200px 2fr 3fr;
grid-template-rows: 1fr 225px 50px 125px 1fr 1fr;
row-gap: 20px;
column-gap: 10px;
justify-content: center;
text-align: center;
grid-template-areas:
  ". . ."
  ". greeting-1 logo"
  ". greeting-2 logo"
  ". create-acct-button nomatic"
  ". log-in-button phonetic"
  ". . .";
}

div#logo {
grid-area: logo;
z-index: 2;
display: flex;
text-align: center;
justify-content: center;
align-items: flex-end;

}

div#greeting-1 {
grid-area: greeting-1;
}

div#greeting-2 {
grid-area: greeting-2;
}

div#create-acct-button {
grid-area: create-acct-button;
z-index: 2;
display: flex;
justify-content: center;
align-items: flex-end;
}

div#nomatic {
grid-area: nomatic;
text-shadow: 0px 3px 3px #00000066;
font-family: Unica One, Helvetica;
font-weight: 400;
color: white;
font-size: 96px;
text-align: center;
z-index: 2;
display: flex;
text-align: center;
justify-content: center;
padding-top: 30px;
}

div#log-in-button {
grid-area: log-in-button;
}

div#phonetic {
grid-area: phonetic;
text-shadow: 0px 3px 3px #00000066;
font-family: Inter, Helvetica;
font-weight: 500;
color: white;
font-size: 40px;
display: flex;
text-align: center;
align-items: flex-start;
justify-content: center;
}

    
</style>