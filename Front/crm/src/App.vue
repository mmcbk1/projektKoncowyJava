<template>
  <div class="container">
    <nav class="navbar navbar-dark bg-warning">
      <router-link class="navbar-brand"  :to="{name:'companies'}">
        Companies
      </router-link>
      <router-link class="navbar-brand"  :to="{name:'users'}">
        Messages
      </router-link>
    </nav>

    <div>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>


export default {
  name: 'app',
}
</script>
