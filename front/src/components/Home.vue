<template>
  <div class="home">
    <div id="nav1">
      <NavigationBar></NavigationBar>
    </div>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import NavigationBar from '@/components/NavigationBar.vue';

@Component({
  components: {
    NavigationBar,
  }
})
export default class Home extends Vue {}
</script>
