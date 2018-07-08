<template>
    <article>
        <div class="form-group col-md-2 col-md-offset-3">
            <label>Nazwa</label>
            <input @blur="search" class="form-control" v-model="department.name" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Krótka nazwa</label>
            <input @blur="search" class="form-control" v-model="department.shortName" type="text"/>
        </div>
        <div class="form-group col-md-2">
            <label>Firma</label>
            <input class="form-control" v-model="department.companyName" type="text"/>
        </div>
        <section>
            <table  class="table table-condensed">
                <thead>
                <th>Nazwa</th>
                <th>Krótka nazwa</th>
                <th>Nazwa firmy</th>
                </thead>
                <tbody>
                <tr v-for="department in results">
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
                results:[
                    {name: 'C++ developer', shortName:'C++', companyName:'Intel'},
                    {name: 'C++ developer', shortName:'C++', companyName:'Intel'},
                    {name: 'C++ developer', shortName:'C++', companyName:'Intel'},
                    {name: 'C++ developer', shortName:'C++', companyName:'Intel'},
                    {name: 'C++ developer', shortName:'C++', companyName:'Intel'}
                ],
                department: {
                    name: '',
                    shortName: '',
                    companyName: '',
                },

            }
        },
        methods: {
            search() {
               this.prepareUrl('name', this.department);
               this.prepareUrl('shortName', this.department);
               this.prepareUrl('companyName', this.department);
                let vm = this;

                return axios.get('search/departments' + this.url)
                    .then(function (response) {
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
