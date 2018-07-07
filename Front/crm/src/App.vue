<template>
  <div class="container">
    <router-link tag="li" :to="{name:'companies'}">
      <a>Companies</a>
    </router-link>
    <router-link tag="li" :to="{name:'users'}">
      <a>Messages</a>
    </router-link>
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
