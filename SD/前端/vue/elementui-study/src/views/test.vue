<template>
  <div>

    <el-button type="text" @click="open">
     点击打开 Message Box
      <router-view></router-view>
    </el-button>
  </div>

</template>

<script>
import cr from './user/children-router'
export default {
  props:['age'],
  methods: {
    open() {
      this.$alert('<strong>这是 <i>HT11111ML</i> 片段</strong>', 'HTML 片段', {
        dangerouslyUseHTMLString: true
      });
    }
  }
}
</script>
