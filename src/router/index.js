import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'


// Import components
import HomePageView from '../views/HomePageView.vue';
import LoginView from '../views/LoginView.vue';



/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'homePage',
    component: HomePageView,
  },

  {
    path: '/login',
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },

  // {
  //   path: '/logout',
  //   name: "logout",
  //   component: LogoutView,
  //   meta: {
  //     requiresAuth: false
  //   }
  // },

  // {
  //   path: "/register",
  //   name: "register",
  //   component: RegisterView,
  //   meta: {
  //     requiresAuth: false
  //   }
  // },


];

// Create the router
const router = createRouter({
    history: createWebHistory(),
    routes: routes
  });


export default router;  