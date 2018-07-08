<template>
    <div class="jumbotron">
        <router-link tag="li" :to="{name:'users-search'}">
            <a>Użytkownicy</a>
        </router-link>
        <router-link tag="li" :to="{name:'departments-search'}">
            <a>Stanowiska</a>
        </router-link>
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: "main-nav",

    }
</script>

<style scoped>

</style>