<template>
    <div>
        <router-link tag="li" :to="{name:'users'}">
            <a>Users</a>
        </router-link>
        <router-link tag="li" :to="{name:'users'}">
            <a>Departments</a>
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