<template>
    <article>
        <section>
            <table class="table table-condensed">
                <thead>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Nazwa firmy</th>
                <th>Nazwa stanowiska</th>
                <th>Data wiadomości</th>
                <th>Powiadomienia</th>
                </thead>
                <tbody>
                <tr v-for="user in results" @click="goToChat(1)">
                    <td>{{user.name}}</td>
                    <td>{{user.lastName}}</td>
                    <td>{{user.companyName}}</td>
                    <td>{{user.departmentName}}</td>
                    <td>{{user.date}}</td>
                    <td>{{user.notifications | notificationFilter}}</td>
                </tr>
                </tbody>
            </table>
        </section>
    </article>
</template>

<script>
    export default {
        data() {
            return {
                results: [
                    {
                        name: 'Jan',
                        lastName: 'Kowalski',
                        date: '09-07-2018',
                        notifications: 1,
                        companyName: 'Intel',
                        departmentName: 'księgowość'
                    },
                    {
                        name: 'Jan',
                        lastName: 'Kowalski',
                        date: '09-07-2018',
                        notifications: 1,
                        companyName: 'Intel',
                        departmentName: 'księgowość'
                    },
                    {
                        name: 'Jan',
                        lastName: 'Kowalski',
                        date: '09-07-2018',
                        notifications: 3,
                        companyName: 'Intel',
                        departmentName: 'księgowość'
                    },
                    {
                        name: 'Jan',
                        lastName: 'Kowalski',
                        date: '09-07-2018',
                        notifications: 2,
                        companyName: 'Intel',
                        departmentName: 'księgowość'
                    },
                    {
                        name: 'Jan',
                        lastName: 'Kowalski',
                        date: '09-07-2018',
                        notifications: 0,
                        companyName: 'Intel',
                        departmentName: 'księgowość'
                    },
                ],

            }
        },
        filters: {
            notificationFilter(val) {
                if (!val) {
                    return '-';
                }

                return val;
            }
        },
        methods:{
            goToChat(recipientId){
                this.$router.push({
                    name: 'chat',
                    params: {recipientId : recipientId}
                })
            }
        }
    }
</script>
<style>
    tr:hover{
        background-color: rgba(63, 150, 191, .3);
        cursor: pointer;
    }
</style>