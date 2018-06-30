import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import {routes} from './routes'
import Axios from 'axios';

window.axios = Axios;
axios.defaults.baseURL = 'http://localhost:8080/';
axios.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

let router = new VueRouter({
    routes,
});
Vue.use(VueRouter);
Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')
