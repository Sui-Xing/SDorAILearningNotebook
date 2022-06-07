// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Axios from 'axios'
import router from './router'

/* eslint-disable no-new */

let vm=new Vue({
  el: '#app',
  // data:{
  //   jsoninfo:{
  //           name:"lhr",
  //           age:"23",
  //           url:null
  //
  //         },
  //
  //
  // },


  data(){
    return {

      jsoninfo:{
        name:null,
        age:null,
        url:null

      }

    }
  },
  router,

  components: { App ,
  },
  template: '<App :jsoninfo="jsoninfo" />',
  // mounted() {
  //   Axios.get('testjson.json').then(response=>this.jsoninfo=response.data);
  //
  // },

})
