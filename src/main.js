import { createApp } from 'vue'
import App from './App.vue'
// import { createStore } from './store'
import router from './router'

// import './css/custom.css'


// createApp(App).mount('#app')

const app = createApp(App);
// app.use(store);
app.use(router);
app.mount('#app');