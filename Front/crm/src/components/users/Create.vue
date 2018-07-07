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
                <label for="birthDate">Data urodzenia</label>
                <date-picker
                        id="birthDate"
                        type="text"
                        v-model="user.birthDate"></date-picker>
            </div>
            <div>
                <label for="password">Hasło</label>
                <input id="password" type="password" v-model="user.password">
            </div>
            <div>
                <label for="passwordConfirm">Potwierdź hasło</label>
                <input id="passwordConfirm" type="password" v-model="user.repeatPassword">
            </div>
            <div>
                <label for="salary">Zarobki</label>
                <input id="salary" type="text" v-model="user.salary">
            </div>
            <div>
                <label for="birthDate">Data zatrudnienia</label>
                <date-picker
                        :format="customFormatter"
                        id="hireDate"
                        type="text"
                        v-model="user.hireDate"></date-picker>
            </div>
            <div>
                <div>
                    <input id="male" type="radio" v-model="user.gender" value="MALE"/>
                    <label for="male">Mężczyzna</label>
                </div>
                <div>
                    <input id="female" type="radio" v-model="user.gender" value="FEMALE"/>
                    <label for="female">Kobieta</label>

                </div>
            </div>
            <div v-if="positions.length">
                <h3>Wybierz stanowisko:</h3>
                <div v-for="position in positions">
                    <input :id="'position_'+position.id" type="radio" v-model="user.positionId" :value="position.id"/>
                    <label :for="'position_'+position.id">{{position.name}}</label>
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
    import {dataPickerMixin} from '../../mixins/dataPickerMixin'
    import Address from '../address/Address'
    export default {
        mixins:[dataPickerMixin],
        data(){
            return {
                user:{
                    name:'',
                    lastName:'',
                    email: '',
                    password:'',
                    hireDate:'',
                    birthDate: '',
                    repeatPassword: '',
                    salary: 0,
                    gender : 'MALE',
                    positionId: 0,
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
            getPositions(){
             let vm = this;
                return axios.get('positions')
                    .then(function(response){
                          vm.positions = response.data;
                        },
                        function(error){
                            console.log(error);
                        });
            },
            storeUser(){
                let vm = this;
                console.log(this.user);
                return axios.post('user', this.user)
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
        },
        created(){
            this.getPositions();
        }
    }
</script>

<style scoped>

</style>