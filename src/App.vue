<template>
  <div>
    <app-header id="app-header" title="Nomatic"/>
    <main id="main-content">
      <router-view />
    </main>
    <app-footer id="app-footer"></app-footer>
  </div>
</template>



<script>
// import HelloWorld from './components/HelloWorld.vue'
import AppHeader from './components/AppHeader.vue';
import AppFooter from './components/AppFooter.vue';

export default {
  components: {AppHeader, AppFooter, MainNav},
}
</script>



<style>
* {
  box-sizing: border-box;
}

html {
  font-family: Inter, Helvetica;
}

body {
  background-color: rgba(255, 255, 255, 1);
  background: linear-gradient(180deg, rgb(0, 24, 113) 0%, rgb(0, 9.93, 46.75) 100%);
  background-repeat: no-repeat;
  background-size: cover;
  width: 100%;
  height: 100vh;
  margin: 0;
}

main {
  width: 100%;
  height: 100vh;
  position: fixed;
}
</style>
