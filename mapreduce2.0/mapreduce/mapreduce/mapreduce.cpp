#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <ctype.h>
#include <algorithm>
#include <sstream>
#include <map>
#include <thread>
#include <ctime>
#include <mutex>

using namespace std;

#define NUM 1500
mutex m;
map<string, vector<int> > shuff;
map<string, int> reduce;
vector<map<string, int> > res;


vector<pair<string, int> > mapping(string x);
void shuffing(vector<pair<string, int> > &smapping);
void Reducing();

vector<vector<string> > reading()
{
	string filename = "D:\\016853\\msup\\mapreduce\\hamlet.txt";
	fstream fin;
	fin.open(filename.c_str(), ios::in);
	string x;
	int i = 0;
	vector<vector<string> > original;
	vector<string> tmp;
	while (getline(fin, x))
	{
		x.erase(remove_if(x.begin(), x.end(), static_cast<int(*)(int)>(&ispunct)), x.end());
		transform(x.begin(), x.end(), x.begin(), ::tolower);
		tmp.push_back(x);	
		if (i == NUM)
		{
			original.push_back(tmp);
			i = 0;
			tmp.clear();
		}
		i++;
	}
	if (i > 0)
	{
		original.push_back(tmp);
	}
	return original;
}


//子线程定义，用于并行处理文本数据
void t(vector<string> s) {
	for (int i = 0; i<s.size(); i++) 
	{
		vector<pair<string, int> > smapping = mapping(s[i]);
		shuffing(smapping);
		//cout << 111 << endl;
	}
}

void startthread(vector<vector<string> > original)
{
	thread th1(t,original[0]);
	thread th2(t,original[1]);
	thread th3(t,original[2]);
	thread th4(t,original[3]);
	th1.join();
	th2.join();
	th3.join();
	th4.join();
}

vector<pair<string, int> > mapping(string x)
{
	vector<string> res;
	vector<pair<string, int> > smapping;
	string result;
	stringstream input(x);
	while (input >> result)
	{
		lock_guard<mutex> lockGuard(m);
		pair<string, int> t(result, 1);
		smapping.push_back(t);
	}
	return smapping;
}

void shuffing(vector<pair<string, int> > &smapping)
{
	m.lock();
	for (auto i = 0; i < smapping.size(); i++)
	{
		string tmp = smapping[i].first;
		if (shuff.find(tmp) == shuff.end())
		{
			vector<int> v;
			v.push_back(1);
			shuff[tmp]= v;
		}
		else
		{
			vector<int> v = shuff[tmp];
			v.push_back(1);
			shuff[tmp] = v;
		}	
	}
	m.unlock();
}

void Reducing()
{
	for (auto iter = shuff.begin(); iter != shuff.end(); iter++)
	{
		//cout << iter->first <<" "<< iter->second.size() << endl;
		reduce[iter->first] = iter->second.size();
		res.push_back(reduce);
	}
}


int main()
{
	clock_t startTime, endTime;
	startTime = clock();//计时开始
	vector<vector<string> > original=reading();
	startthread(original);
	Reducing();
	cout <<"单词数量："<< res.size() << endl;
	endTime = clock();//计时结束
	cout << "The run time is: " << (double)(endTime - startTime) / CLOCKS_PER_SEC << "s" << endl;
	return 0;
}