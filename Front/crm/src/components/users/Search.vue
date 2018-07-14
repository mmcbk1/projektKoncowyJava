<template>
    <article>
        <div class="form-group col-md-2">
            <label>Imię</label>
            <input class="form-control"
                   placeholder="Natalia"
                   v-model="user.name" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Nazwisko</label>
            <input class="form-control"
                   placeholder="Kowalska"
                   v-model="user.lastName" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>E-mail</label>
            <input class="form-control"
                   placeholder="nat.kow@web.it"
                   v-model="user.email" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Nazwa firmy</label>
            <input class="form-control"
                   placeholder="np. Intel"
                   v-model="user.companyName" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Nazwa stanowiska</label>
            <input class="form-control"
                   placeholder="Software Developer"
                   v-model="user.positionName" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Akcja</label>
            <button type="submit"
                    @click="search"
                    class="btn btn-primary form-control">Szukaj</button>
        </div>
        <section class="col-md-8 col-lg-offset-2" v-if="results.length">
            <table class="table table-condensed">
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
                    <td>{{user.positionName}}</td>
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
                searchUrl: '/users/search',
                results: [],
                user: {
                    name: '',
                    lastName: '',
                    email: '',
                    companyName: '',
                    positionName: '',
                },

            }
        },
        methods: {
            search() {
                let url = this.searchUrl;
                url += this.addToUrlGet(url, 'name', this.user.name);
                url += this.addToUrlGet(url, 'lastName', this.user.lastName);
                url += this.addToUrlGet(url, 'email', this.user.email);
                url += this.addToUrlGet(url, 'companyName', this.user.companyName);
                url += this.addToUrlGet(url, 'positionName', this.user.positionName);
                let vm = this;
                return axios.get(url)
                    .then(function (response) {
                            console.log(response.data);
                            vm.results = response.data.content;
                        },
                        function (error) {

                        });
            },

        },
        goToUser(cid, did, iid){
            this.$router.push({
                name:'user-single',
                params:{
                    cid:cid,
                    did:did,
                    uid:uid
                }
            })
        }
    }
</script>
