	class Solution {
		public int sumCounts(int[] a) {
			int n = a.length;
			final int mod = 1000000007;
			int[] prev = new int[100001];
			Arrays.fill(prev, -1);

			long ans = 0;
			long S = 0;
			SegmentTreeRSQ st = new SegmentTreeRSQ(n+2);
			for(int i = 0;i < n;i++){
				int v = a[i];
				int p = prev[v];
				long t = st.sum(p+1, i+1);
				S += i-p + 2*t;
				S %= mod;
				st.add(p+1, i+1, 1);
				prev[v] = i;
				ans += S;
				ans %= mod;
			}
			return (int)ans;
		}

		public class SegmentTreeRSQ {
			public int M, H, N;
			public long[] st;
			public long[] plus;

			public SegmentTreeRSQ(int n)
			{
				N = n;
				M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
				H = M>>>1;
				st = new long[M];
				plus = new long[H];
			}

			public SegmentTreeRSQ(int[] a)
			{
				N = a.length;
				M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
				H = M>>>1;
				st = new long[M];
				plus = new long[H];
				for(int i = 0;i < N;i++){
					st[H+i] = a[i];
				}
				for(int i = (M>>1)-1;i >= 1;i--){
					propagate(i);
				}
			}

			public void add(int pos, int v)
			{
				for(int i = H+pos;i >= 1;i >>>= 1){
					st[i] += v;
				}
			}

			private void propagate(int i)
			{
				int count = H/Integer.highestOneBit(i);
				st[i] = st[2*i]+st[2*i+1]+plus[i]*count;
			}

			public void add(int l, int r, int v) { if(l < r)add(l, r, v, 0, H, 1); }

			private void add(int l, int r, int v, int cl, int cr, int cur)
			{
				if(cur >= H){
					st[cur] += v;
				}else if(l <= cl && cr <= r){
					plus[cur] += v;
					propagate(cur);
				}else{
					int mid = cl+cr>>>1;
					if(cl < r && l < mid){
						add(l, r, v, cl, mid, 2*cur);
					}
					if(mid < r && l < cr){
						add(l, r, v, mid, cr, 2*cur+1);
					}
					propagate(cur);
				}
			}

			private long gsum;

			public long sum(int l, int r) {
				gsum = 0;
				sum(l, r, 0, H, 1);
				return gsum;
			}

			private void sum(int l, int r, int cl, int cr, int cur)
			{
				if(l <= cl && cr <= r){
					gsum += st[cur];
				}else{
					int mid = cl+cr>>>1;
					if(cl < r && l < mid){
						sum(l, r, cl, mid, 2*cur);
					}
					if(mid < r && l < cr){
						sum(l, r, mid, cr, 2*cur+1);
					}
					gsum += plus[cur]*(Math.min(r,cr)-Math.max(l,cl));
				}
			}
		}

	}