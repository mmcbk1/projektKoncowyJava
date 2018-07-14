<template>
    <div>
        <article class="col-md-3">
            <section>
                <h3>Dane użytkownika:</h3>
                <!--<h3>Nazwa firmy: {{user.department.companyName}}</h3>
                <h2>Nazwa stanowiska: {{user.department.position.name}}</h2>-->
                <div>
                    <label class="my-label">Imię:</label> {{user.name}}
                </div>
                <div>
                    <label class="my-label">Nazwisko:</label> {{user.lastName | setEmptyChar}}
                </div>
                <div>
                    <label class="my-label">E-mail:</label> {{user.email | setEmptyChar}}
                </div>
            </section>
            <section class="form-group">
                <crm-address-display
                        :address="user.address"
                ></crm-address-display>
            </section>
            <section>
                <div class="form-group">
                    <textarea v-model="message.content" class="form-control" placeholder="napisz do mnie.."></textarea>
                </div>
                <div class="form-group">
                    <button class="btn btn-success">Wyślij</button>
                </div>
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
                user: {
                    name: '',
                    lastName: '',
                    email: '',
                    department: {},
                    company: {},
                    address: {},
                },
                message: {
                    content: ''
                }
            }
        },
        methods: {
            getUser() {
                let uid = this.$route.params.uid;
                let vm = this;
                return axios.get('user/' + uid)
                    .then(function (response) {
                            console.log(response.data);
                            vm.user = response.data;
                        },
                        function (error) {

                        })
            },
        },
        created() {
            this.getUser();
        }
    }
</script>

<style scoped>
    textarea {
        resize: none;
    }
</style>