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
                    department_id : this.$route.params.did,
                }
            }
        },
        methods:{

            storePosition(){
                return axios.post('position', this.position)
                    .then(function(response){
                        console.log(response.data);
                            vm.$router.push({
                                name:'company-single',
                                params:{cid:vm.$route.params.cid}
                            });
                    },
                    function(error){

                    })
            }
        }
    }
</script>