<template>
  <div id="app">
    <img src="src/assets/logo.png">
    <h1>测试点</h1>
    <h1>测试router</h1>
    <router-link to="/door" >门户</router-link>
    <router-link to="/content1" >内容</router-link>
    <router-link to="/author" >作者</router-link>
    <router-view></router-view>

    <br>
    <br>
    <h1>测试axios</h1>
    name<p>{{jsoninfo.name}}</p>

<!--    age<p>{{jsoninfo.age}}</p>-->
  </div>
</template>

<script>


import Axios from "axios";
import jsonfile from "./testjson.json"
export default {
  props:['jsoninfo'],
  name: 'App',
  mounted() {
    Axios.get(jsonfile).then(response=>this.jsoninfo=response.data);

  },

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
