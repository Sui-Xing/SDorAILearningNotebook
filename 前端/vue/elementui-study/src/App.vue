<template >
  <div id="app">
    <img src="./assets/logo.png">

          <Main>
            <HelloWorld slot="HelloWorld" :testdata="testdata"></HelloWorld>
            <Login slot="Login"></Login>
          </Main>

<!--    <test></test>-->
    <br>


<!--    <router-view></router-view>-->
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import test from './views/test'
import Main from './views/main'
import Login from './views/Login'


export default {
  name: 'App',
  props:['testdata'],
  components: {
    HelloWorld,test,Main,Login
  }
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
