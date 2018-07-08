<template>
    <article>
        <div class="form-group col-md-2 col-md-offset-1">
            <label>Imię</label>
            <input class="form-control" v-model="user.name" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Nazwisko</label>
            <input class="form-control" v-model="user.lastName" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>E-mail</label>
            <input class="form-control" v-model="user.email" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Nazwa firmy</label>
            <input class="form-control" v-model="user.companyName" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Nazwa stanowiska</label>
            <input class="form-control" v-model="user.departmentName" type="text"/>
        </div>
        <section>
            <table  class="table table-condensed">
                <thead>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>E-mail</th>
                <th>Nazwa Firmy</th>
                <th>Nazwa stanowiska</th>
                </thead>
                <tbody>
                <tr v-for="user in results">
                    <td>{{user.name}}</td>
                    <td>{{user.lastName}}</td>
                    <td>{{user.email}}</td>
                    <td>{{user.companyName}}</td>
                    <td>{{user.departmentName}}</td>
                </tr>
                </tbody>
            </table>
        </section>
    </article>
</template>

<script>
    import {prepareGetParams} from "../../mixins/prepareGetParams";

    export default {
        mixins: [prepareGetParams],
        data() {
            return {
                results:[
                    {
                        name: 'Anna',
                        lastName:'Kowalski',
                        email: 'anna.kowalski@intel.com',
                        companyName:'Intel',
                        departmentName:'Junior developer'
                    },  {
                        name: 'Anna',
                        lastName:'Kowalski',
                        email: 'anna.kowalski@intel.com',
                        companyName:'Intel',
                        departmentName:'Junior developer'
                    },  {
                        name: 'Anna',
                        lastName:'Kowalski',
                        email: 'anna.kowalski@intel.com',
                        companyName:'Intel',
                        departmentName:'Junior developer'
                    },  {
                        name: 'Anna',
                        lastName:'Kowalski',
                        email: 'anna.kowalski@intel.com',
                        companyName:'Intel',
                        departmentName:'Junior developer'
                    },

                ],
                user: {
                    name: '',
                    lastName: '',
                    email: '',
                    companyName: '',
                    departmentName: '',
                },

            }
        },
        methods: {
            search() {
                let name = this.prepareUrl('name', this.user);
                let lastName = this.prepareUrl('lastName', this.user);
                let email = this.prepareUrl('email', this.user);
                let companyName = this.prepareUrl('companyName', this.user);
                let departmentName = this.prepareUrl('departmentName', this.user);
                let vm = this;

                return axios.get(
                    'search/companies'
                    + name
                    + lastName
                    + email
                    + companyName
                    +departmentName
                ).then(function (response) {
                            console.log(response.data);
                        },
                        function (error) {

                        }).then(function () {
                        vm.resetUrl();
                    })
            },

        },
    }
</script>
