<template>
    <article>
        <div class="form-group col-md-2 col-md-offset-2">
            <label>Nazwa</label>
            <input  class="form-control"
                    placeholder="Web"
                    v-model="department.name"
                    type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Krótka nazwa</label>
            <input
                    class="form-control"
                    placeholder="IT"
                    v-model="department.shortName" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Firma</label>
            <input class="form-control"
                   placeholder="Intel"
                   v-model="department.companyName" type="text"/>
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
                <th>Nazwa</th>
                <th>Krótka nazwa</th>
                <th>Nazwa firmy</th>
                </thead>
                <tbody>
                <tr @click="gotToDepartment(department.company_id, department.id)" v-for="department in results">
                    <td>{{department.name}}</td>
                    <td>{{department.shortName}}</td>
                    <td>{{department.companyName}}</td>
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
                searchUrl: '/search/departments',
                results: [],
                department: {
                    name: '',
                    shortName: '',
                    companyName: '',
                },

            }
        },
        methods: {
            search() {
                let url = this.searchUrl;
                url += this.addToUrlGet(url, 'name', this.department.name);
                url += this.addToUrlGet(url, 'shortName', this.department.shortName);
                url += this.addToUrlGet(url, 'companyName', this.department.companyName);
                let vm = this;

                return axios.get(url)
                    .then(function (response) {
                            console.log(response.data);
                            vm.results = response.data.content;
                        },
                        function (error) {
                        }
                    );
            },
            gotToDepartment(companyid, departmentId){
                this.$router.push({
                    name:'department-single',
                    params:{
                        cid: companyid,
                        did: departmentId
                    }
                })
            }
        },
        mounted(){
            this.search();
        }
    }
</script>
<style scoped>

</style>