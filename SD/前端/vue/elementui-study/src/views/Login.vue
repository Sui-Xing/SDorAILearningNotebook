
<template>
  <el-form :model="numberValidateForm" ref="numberValidateForm" label-width="100px" class="demo-ruleForm">
    <router-link to="/cr">children-router</router-link>
    <router-link :to="{name:'Test',params:{age:numberValidateForm.age}}">test</router-link>
<!--    <router-link to="/test">children-router</router-link>-->

<!--    <router-view></router-view>-->
    <el-form-item
      label="年龄"
      prop="age"
      :rules="[
      { required: true, message: '年龄不能为空'},
      { type: 'number', message: '年龄必须为数字值'}
    ]"
    >
      <el-input type="age" v-model.number="numberValidateForm.age" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
<!--      <el-button type="primary" @click="submitForm('numberValidateForm')" :route="{ path: '/test', query: { age:numberValidateForm.age }}">-->
      <el-button type="primary" @click="submitForm('numberValidateForm')" >

        提交
<!--        <router-link :to="{name:'Test',params:{age:numberValidateForm.age}}">children-router</router-link>-->

      </el-button>
      <el-button @click="resetForm('numberValidateForm')">重置</el-button>
    </el-form-item>
    <router-view></router-view>
  </el-form>

</template>


<script>

export default {
  data() {
    return {
      numberValidateForm: {
        age: ''
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
          this.$router.push("/test/"+this.numberValidateForm.age)
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

