<template>
  <el-row class="tac">
    <el-row :gutter="10">
      <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4"><div class="grid-content bg-purple">
        <h5>自定义颜色</h5>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          router>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>导航一</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
          </el-menu-item>
          <el-menu-item index="4" :index="'login'" >
            <i class="el-icon-setting"></i>

<!--             <router-link to="/cr">children-router</router-link>-->
            <span slot="title">导航四</span>

          </el-menu-item>
        </el-menu>
      </div></el-col>
      <el-col :xs="20" :sm="20" :md="20" :lg="20" :xl="20"><div class="grid-content bg-purple-light">
<!--        <slot name="HelloWorld"><router-view></router-view></slot>-->
<!--        <router-view></router-view>-->
<!--        <slot name="Login"></slot>-->
        <router-view></router-view>
      </div></el-col>

    </el-row>

  </el-row>

</template>


<script>


export default {

  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>
