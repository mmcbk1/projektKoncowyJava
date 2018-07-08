<template>
    <article class="container">
        <div class="col-md-4 col-md-offset-4 bg-warning">
            <div class="chat-wrapper" ref="chat">
                <section class="message"
                         :class="{
                         'bg-info': $route.params.recipientId == message.user.id,
                         'bg-success' : $route.params.recipientId != message.user.id
                         }" v-for="message in messages">
                    <div class="chat-info-wrapper">
                        <span class="pull-left">{{message.date}}</span>
                        <span class="pull-right">{{message.user.name}} {{message.user.lastName}}</span>
                        <div class="clearfix"></div>
                    </div>
                    <div>
                        {{message.content}}
                    </div>
                </section>

            </div>
            <div class="form-group">
                <div class="form-group">
                    <textarea placeholder="napisz wiadomość..."
                              v-model="content"
                              @keyup.enter="storeMessage()"
                              class="form-control"></textarea>
                </div>
                <div>
                    <button class="btn btn-success"
                            @click="storeMessage()">Wyślij</button>
                </div>
            </div>
        </div>
    </article>
</template>

<script>
    import moment from 'moment';
    export default {
        name: "chat",
        data(){
            return{
                content: '',
                messages:[
                    {
                        user:{
                            id:1,
                            name: 'Jan',
                            lastName: 'Kowalski',
                        },
                        date:'08-09-2018',
                        content:'dasd asd asd as das d as das'
                    },
                    {
                        user:{
                            id:1,
                            name: 'Jan',
                            lastName: 'Kowalski',
                        },
                        date:'08-09-2018',
                        content:'dasd asd asd as das d as das'
                    },
                    {
                        user:{
                            id:1,
                            name: 'Jan',
                            lastName: 'Kowalski',
                        },
                        date:'08-09-2018',
                        content:'dasd asd asd as das d as das'
                    },
                    {
                        user:{
                            id:1,
                            name: 'Jan',
                            lastName: 'Kowalski',
                        },
                        date:'08-09-2018',
                        content:'dasd asd asd as das d as das'
                    }, {
                        user:{
                            id:1,
                            name: 'Jan',
                            lastName: 'Kowalski',
                        },
                        date:'08-09-2018',
                        content:'dasd asd asd as das d as das'
                    },
                    {
                        user:{
                            id:1,
                            name: 'Jan',
                            lastName: 'Kowalski',
                        },
                        date:'08-09-2018',
                        content:'dasd asd asd as das d as das'
                    }
                ]
            }
        },
        methods: {
            setScroll(){
                this.$refs.chat.scrollTop = 800;
            },
            storeMessage(){
                let vm = this;
                this.messages.push({
                    user:{
                        id:2,
                        name:'You',
                        lastName: ''
                    },
                    date: moment(new Date()).format('DD-MM-YYYY'),
                    content:this.content
                });
                this.content = '';
                setTimeout(function(){
                    vm.setScroll();
                },1)
            }
        },
        mounted() {
            this.setScroll();
        }
    }
</script>

<style scoped>
    .message {
        padding: 15px;
        margin-bottom: 20px;
        margin-top: 20px;
    }

    .chat-info-wrapper {
        margin-bottom: 10px;
    }

    .chat-wrapper {
        margin-bottom: 20px;
        max-height: 300px;
        overflow: hidden;
        overflow-y: scroll;
    }

    textarea {
        resize: none;
    }

</style>