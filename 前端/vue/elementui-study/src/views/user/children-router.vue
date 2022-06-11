<template>
  <div>
    <p>这是嵌套路由</p>
    {{jsoninfo.name}}
  </div>

<!--  <p>{{jsoninfo.name}}</p>-->
</template>

<script>
export default {
  name: "children-router",


  data: function() {
    return {
      testdata: 'testdata',
      jsoninfo:{
                  name:"lhr",
                  age:"23",
                  url:null

                },
    };
  },

  beforeRouteEnter:(to,from,next)=>{
    console.log('start');
    next((vm)=>{
      vm.getData();
    });
  },
  methods:{

    getData:function () {
      let s={};
      this.axios({
        method:'get',
        url:'http://localhost:8080/static/mock/testjson.json',

      }).then( (response)=>{
        console.log(this.jsoninfo=response.data)
        // response.data;
      })
      console.log(s)
      return s;
    }
  }
}
</script>

<style scoped>

</style>
