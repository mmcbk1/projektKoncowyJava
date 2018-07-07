<template>
    <article>
       <div>
           <label for="name">Nazwa pozycji</label>
           <input type="text" v-model="position.name" id="name"/>
       </div>
        <div>
            <button type="submit" @click="storePosition()">Zapisz</button>
        </div>
    </article>
</template>

<script>
    export default {
        data(){
            return{
                position:{
                    name: '',
                    departmentId : this.$route.params.did,
                }
            }
        },
        methods:{

            storePosition(){
                let vm = this;
                return axios.post('position', this.position)
                    .then(function(response){
                            vm.$router.push({
                                name:'department-single',
                                params:{cid:vm.$route.params.did}
                            });
                    },
                    function(error){

                    })
            }
        }
    }
</script>