<template>
    <div>
        <h1>{{ contentType }}</h1>
        <router-view></router-view>
    </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name: 'UserView',
    components: {
        ...mapState("mapStore",["contentType"]),
    },
    data() {
        return {
            message: '',
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped></style>