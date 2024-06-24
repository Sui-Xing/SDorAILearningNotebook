import Vue from 'vue';
import VueRouter from "vue-router";
import door from '../components/door'
import content1 from '../components/content1'
import author from '../components/author'




Vue.use(VueRouter)

export default new VueRouter({
  routes:[
    {
      path:'/door',
      name:"door",
      component:door,

    },
    {
      path:'/content1',
      name:"content1",
      component:content1,

    },
    {
      path:'/author',
      name:"author",
      component:author,

    },
  ]
})
