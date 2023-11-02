<template>
    <header>
        <main-nav id="main-nav"/>
    </header>
</template>

<script>
import MainNav from './MainNav.vue';

export default {
    components: {MainNav}
}
</script>


<style scoped>
header {
  position: fixed;
  display: flex;
  width: 100%;
  z-index: 1;
}    


</style>