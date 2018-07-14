<template>
    <div>
        <article class="col-md-3">
            <h3>Dane osobowe:</h3>
            <div class="form-group">
                <label for="name">Imie</label>
                <input class="form-control" id="name" type="text" v-model="user.name">
            </div>
            <div class="form-group">
                <label for="lastName">Nazwisko</label>
                <input class="form-control" id="lastName" type="text" v-model="user.lastName">
            </div>
            <div class="form-group">
                <label for="email">E-mail</label>
                <input class="form-control" id="email" type="email" v-model="user.email">
            </div>
            <div class="form-group">
                <label for="birthDate">Data urodzenia</label>
                <date-picker
                        id="birthDate"
                        type="text"
                        v-model="user.birthDate"></date-picker>
            </div>
            <div class="form-group">
                <label for="password">Hasło</label>
                <input class="form-control" id="password" type="password" v-model="user.password">
            </div>
            <div class="form-group">
                <label for="passwordConfirm">Potwierdź hasło</label>
                <input class="form-control" id="passwordConfirm" type="password" v-model="user.repeatPassword">
            </div>
            <div class="form-group">
                <label for="salary">Zarobki</label>
                <input class="form-control" id="salary" type="text" v-model="user.salary">
            </div>
            <div class="form-group">
                <label for="birthDate">Data zatrudnienia</label>
                <date-picker
                        :format="customFormatter"
                        id="hireDate"
                        type="text"
                        v-model="user.hireDate"></date-picker>
            </div>
            <div class="form-group">
                <div class="radio">
                    <label for="male">
                        <input id="male" type="radio" v-model="user.gender" value="MALE"/>
                        Mężczyzna
                    </label>
                </div>
                <div class="radio">

                    <label for="female">
                        <input id="female" type="radio" v-model="user.gender" value="FEMALE"/>
                        Kobieta
                    </label>

                </div>
            </div>
        </article>

        <article class="col-md-3">
            <crm-address
                    @updateAddress="updateAddress($event)"
            ></crm-address>
        </article>
        <article class="col-md-3">
            <div v-if="positions.length">
                <h3>Wybierz stanowisko:</h3>
                <div class="radio" v-for="position in positions">
                    <label :for="'position_'+position.id">
                        <input :id="'position_'+position.id" type="radio" v-model="user.positionId" :value="position.id"/>
                        {{position.name}}
                    </label>
                </div>
            </div>
        </article>
        <div class="clearfix"></div>
        <div>
            <button class="btn btn-success"
                    type="submit" @click="storeUser()">Zapisz</button>
        </div>
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