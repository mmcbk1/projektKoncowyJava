<template>
    <div class="jumbotron">
        <div class="col-md-6 col-md-offset-3">
            <div class="form-group">
                <label>Login:</label>
                <input type="text"
                       class="form-control"
                       v-model="credentials.login"/>
            </div>
            <div class="form-group">
                <label>Hasło:</label>
                <input type="password"
                       class="form-control"
                       v-model="credentials.password"/>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data(){
            return{
                credentials:{
                    login:'',
                    password:''
                }
            }
        },

    }
</script>

<style scoped>

</style>