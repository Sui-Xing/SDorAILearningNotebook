import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login.vue'
import test from '../views/test.vue'
import cr from '../views/user/children-router'


Vue.use(Router);
export default new Router({


  mode:'history',
  routes:[
    {
      name:'Login',
      path:'/login',
      component:Login,
      children:[
        {
          name:'cr',
          path:'/cr',
          component:cr,
        },
        {
          name:'Test',
          path:'/test/:age',
          props:true,
          component:test

        }

      ]
    }
  ],

})

