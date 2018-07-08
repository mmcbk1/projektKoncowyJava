<template>
   <div>
       <nav class="navbar navbar-default">
           <router-link class="navbar-brand"  :to="{name:'users-search'}">
             Użytkownicy
           </router-link>
           <router-link class="navbar-brand" :to="{name:'departments-search'}">
              Stanowiska
           </router-link>
       </nav>
       <div>
           <router-view></router-view>
       </div>
   </div>

</template>

<script>
    export default {
        name: "main-nav",

    }
</script>

<style scoped>

</style>