<template>
  <div>
    {{ yearAndMonth }}
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component
export default class TextYearAndMonth extends Vue {
  @Prop({
    default: () => {
      const now = new Date();
      return now.getFullYear();
    }
  })
  public year?: number;

  @Prop({
    default: () => {
      const now = new Date();
      return now.getMonth() + 1;
    }
  })
  public month?: number;

  public yearAndMonth = `${this.year}年${this.month}月`;
}
</script>
