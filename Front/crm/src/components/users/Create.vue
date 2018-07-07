<template>
    <div>
        <article>
            <h3>Dodawanie użytkownika:</h3>
            <div>
                <label for="name">Imie</label>
                <input id="name" type="text" v-model="user.name">
            </div>
            <div>
                <label for="lastName">Nazwisko</label>
                <input id="lastName" type="text" v-model="user.lastName">
            </div>
            <div>
                <label for="email">E-mail</label>
                <input id="email" type="email" v-model="user.email">
            </div>
            <div>
                <label for="password">Hasło</label>
                <input id="password" type="password" v-model="user.password">
            </div>
            <div>
                <label for="passwordConfirm">Potwierdź hasło</label>
                <input id="passwordConfirm" type="password" v-model="user.passwordConfirm">
            </div>
            <div>
                <label for="salary">Zarobki</label>
                <input id="salary" type="text" v-model="user.salary">
            </div>
            <div>
                <div>
                    <label for="male">Mężczyzna</label>
                    <input id="male" type="radio" v-model="user.gender" value="male"/>
                </div>
                <div>
                    <label for="female">Kobieta</label>
                    <input id="female" type="radio" v-model="user.gender" value="female"/>
                </div>
            </div>
            <div v-if="positions.length">
                <div v-for="position in positions">
                    <label :for="'position_'+position.id">{{position.name}}</label>
                    <input type="radio" v-model="user.position_id" :value="position.id"/>
                </div>
            </div>
            <crm-address
                    @updateAddress="updateAddress($event)"
            ></crm-address>
            <div>
                <button type="submit" @click="storeUser()">Zapisz</button>
            </div>
        </article>
    </div>
</template>


<script>
    import Address from '../address/Address'
    export default {
        data(){
            return {
                user:{
                    name:'',
                    lastName:'',
                    email: '',
                    password:'',
                    passwordConfirm: '',
                    salary: 0,
                    gender : 'male',
                    position_id: 0,
                    address:{},
                },
                positions:[],
            }
        },
        components:{
            'crm-address' : Address
        },
        methods:{
            updateAddress(address){
                this.user.address = address;
            },
            storeUser(){
                let vm = this;
                return axios.post('user', this.department)
                    .then(function(response){
                            vm.$router.push({
                                name:'department-single',
                                params:{
                                    cid:vm.$route.params.cid,
                                    did:vm.$route.params.did,
                                }
                            });
                        },
                        function(error){
                            console.log(error);
                        });
            }
        }
    }
</script>

<style scoped>

</style>