<template>
    <div>
        <article>
            <section>
                <router-link tag="div" :to="{
                name:'user-create',
                params:{cid:$route.params.cid, did:$route.params.cid}
                }">
                    <a>Dodaj usera</a>
                </router-link>
            </section>
            <section>
                <router-link tag="div" :to="{
                name:'position-create',
                params:{cid:$route.params.cid}
                }">
                    <a>Dodaj Stanowisko</a>
                </router-link>
            </section>
            <section>
                <h3>Nazwa firmy: {{department.companyName}}</h3>
                <div>Nazwa {{department.name}}</div>
                <div>Krótka nazwa {{department.shortName}}</div>
            </section>
            <crm-address-display
                    :address="department.address"
                 ></crm-address-display>
            <section v-if="department.users">
                <h3>Lista użytkowników</h3>
                <ul>
                    <li v-for="user in department.users" :key="user.id">
                        <router-link :to="{name:'user-single', params:{
                        cid:$route.params.cid,
                        did:$route.params.did,
                        uid:user.id,
                        }}">
                            {{user.name}}
                            {{user.lastName}}
                        </router-link>

                    </li>
                </ul>
            </section>
            <section v-if="department.positions.length">
                <h3>Stanowiska</h3>
                <div v-for="(position, i) in department.positions">
                    <span>{{position.name}}</span>
                    <span @click="deletePosition(position.id, i)"> usuń</span>
                </div>
            </section>
        </article>

    </div>
</template>

<script>
    import AddressDisplay from '../address/AddressDisplay'

    export default {

        components: {
            'crm-address-display': AddressDisplay
        },
        data() {
            return {
                department: {
                    name: '',
                    shortName: '',
                    companyName: '',
                    users: [],
                    positions:[],
                    address: {},
                }
            }
        },
        methods: {
            getDepartment() {
                let did = this.$route.params.did;
                let vm = this;
                return axios.get('department/'+did)
                    .then(function (response) {
                        console.log(response.data);
                            vm.department = response.data;
                        },
                        function (error) {

                        })
            },
            deletePosition(id, i){
                let vm = this;
                console.log(i);
               return axios.delete('position/'+id)
                    .then(function(response){
                           vm.department.position.slice(i,1);
                    },
                    function(error){

                    })
            }
        },
        created() {
            this.getDepartment();
        }
    }
</script>

<style scoped>

</style>