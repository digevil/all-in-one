import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../view/home.vue';
import Login from '../view/login.vue';

Vue.use(VueRouter);

const router = new VueRouter({
  hashbang: true,
  history: true
}); //这里可以带有路由器的配置参数

router.map({
  '/': {
    component: Home
  },
  '/login': {
    component: Login
  }
});

export default router; //将路由器导出