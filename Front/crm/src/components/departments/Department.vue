<template>
    <div>
        <article>
            <section class="btn-wrapper">
                <router-link tag="button" class="btn btn-success" :to="{
                name:'user-create',
                params:{cid:$route.params.cid, did:$route.params.cid}
                }">
                    Dodaj usera
                </router-link>
            </section>
            <section class="btn-wrapper">
                <router-link tag="button" class="btn btn-success" :to="{
                name:'position-create',
                params:{cid:$route.params.cid}
                }">
                    Dodaj Stanowisko
                </router-link>
            </section>
            <section>
                <h3>Nazwa firmy: {{department.companyName}}</h3>
                <div>
                    <label class="my-label">Nazwa:</label> {{department.name}}
                </div>
                <div>
                    <label class="my-label">Krótka nazwa:</label> {{department.shortName}}
                </div>
            </section>
            <crm-address-display
                    :address="department.address"
            ></crm-address-display>
            <section v-if="department.users">
                <h3>Lista użytkowników</h3>
                <table class="table table-condensed">
                    <thead>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>E-mail</th>
                    </thead>
                    <tbody>
                    <tr v-for="user in department.users" :key="user.id" @click="gotToUser(user.id)">
                        <td>{{user.name | setEmptyChar}}</td>
                        <td>{{user.lastName | setEmptyChar}}</td>
                        <td>{{user.email | setEmptyChar}}</td>
                    </tr>
                    </tbody>
                </table>
            </section>
            <section v-if="department.positions.length">
                <h3>Stanowiska: </h3>
                <table class="table table-condensed">
                    <thead>
                    <th>Nazwa</th>
                    <th>Akcja</th>
                    </thead>
                    <tbody>
                    <tr v-for="(position, i) in department.positions">
                        <td>{{position.name | setEmptyChar}}</td>
                        <td>
                            <span @click="deletePosition(position.id, i)" class="delete">usuń</span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </section>
        </article>

    </div>
</template>

<script>
    import AddressDisplay from '../address/AddressDisplay'
    import {filters} from "../../mixins/filters";

    export default {
        mixins: [filters],
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
                    positions: [],
                    address: {},
                }
            }
        },
        methods: {
            getDepartment() {
                let did = this.$route.params.did;
                let vm = this;
                return axios.get('department/' + did)
                    .then(function (response) {
                            console.log(response.data);
                            vm.department = response.data;
                        },
                        function (error) {

                        })
            },
            gotToUser(userId) {
                this.$router.push(
                    {
                        name: 'user-single', params: {
                            cid: this.$route.params.cid,
                            did: this.$route.params.did,
                            uid: userId,
                        }
                    }
                );
            },
            deletePosition(id, i) {
                let vm = this;
                console.log(i);
                return axios.delete('position/' + id)
                    .then(function (response) {
                            vm.department.position.slice(i, 1);
                        },
                        function (error) {

                        })
            }
        },
        created() {
            this.getDepartment();
        }
    }
</script>

<style scoped>
    .btn-wrapper {
        display: inline-block;
        margin-right: 10px;
    }
    .delete{
        padding: 7px;
    }
    .delete:hover{
        cursor: pointer;
        color: #fff;

        background-color: indianred;
    }
</style>